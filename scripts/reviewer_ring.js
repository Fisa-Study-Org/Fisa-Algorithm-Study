import fs from "fs";
import path from "path";

// ----- 설정 -----
const ROOT = process.cwd();
const { members } = JSON.parse(
  fs.readFileSync(path.join(ROOT, "scripts/reviewers.json"), "utf-8")
);

// KST 기준 ISO 주차 구하기 (월요일 시작)
function getKSTIsoWeek() {
  const now = new Date();
  // KST로 보정: UTC+9
  const kst = new Date(now.getTime() + 9 * 60 * 60 * 1000);

  // ISO 주차 계산
  const date = new Date(Date.UTC(kst.getUTCFullYear(), kst.getUTCMonth(), kst.getUTCDate()));
  // 목요일 기준 주차
  const dayNum = (date.getUTCDay() + 6) % 7;
  date.setUTCDate(date.getUTCDate() - dayNum + 3);
  const firstThursday = new Date(Date.UTC(date.getUTCFullYear(), 0, 4));
  const week = 1 + Math.round(
    ((date - firstThursday) / 86400000 - 3 + ((firstThursday.getUTCDay() + 6) % 7)) / 7
  );
  const year = date.getUTCFullYear();
  return { year, week, label: `${year}-W${week}` };
}

// 배열을 왼쪽으로 k칸 회전
function rotate(arr, k) {
  const n = arr.length;
  const r = ((k % n) + n) % n;
  return arr.slice(r).concat(arr.slice(0, r));
}

// 원형 매칭 만들기: x_i → x_(i+1), 마지막은 → x_0
function makeRingPairs(list) {
  const res = [];
  for (let i = 0; i < list.length; i++) {
    const reviewer = list[i];
    const reviewee = list[(i + 1) % list.length];
    res.push({ reviewer, reviewee });
  }
  return res;
}

function buildSlackPayload(title, pairs) {
  const lines = pairs.map(p => `• *${p.reviewer}* → ${p.reviewee}`);
  return { text: `${title}\n\n${lines.join("\n")}` };
}

async function postToSlack(payload) {
  const url = process.env.SLACK_WEBHOOK_URL; // GitHub Secret
  if (!url) {
    console.log("SLACK_WEBHOOK_URL 미설정. 콘솔 출력:\n");
    console.log(payload.text);
    return;
  }
  const res = await fetch(url, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(payload),
  });
  if (!res.ok) {
    throw new Error(`Slack post failed: ${res.status} ${await res.text()}`);
  }
}

(async () => {
  if (!Array.isArray(members) || members.length < 2) {
    throw new Error("members가 2명 이상 필요합니다.");
  }
  const { label, week } = getKSTIsoWeek();
  const rotated = rotate(members, week);     // 주차 기반 시작점 회전
  const pairs = makeRingPairs(rotated);
  const payload = buildSlackPayload(`:arrows_clockwise: 주간 원형 코드리뷰 (${label})`, pairs);
  await postToSlack(payload);
  console.log("배정 완료:\n" + payload.text);
})();
