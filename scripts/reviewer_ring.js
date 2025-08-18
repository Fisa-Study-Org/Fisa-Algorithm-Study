// scripts/review-assign.js
import fs from "fs";
import path from "path";

// ----- 설정 -----
const ROOT = process.cwd();
const { members } = JSON.parse(
  fs.readFileSync(path.join(ROOT, "scripts/reviewers.json"), "utf-8")
);

// ---------- 유틸 ----------
// 오늘 날짜(한국시간) YYYY-MM-DD
function getKSTDateLabel() {
  const now = new Date();
  const kst = new Date(now.getTime() + 9 * 60 * 60 * 1000); // UTC+9
  const y = kst.getUTCFullYear();
  const m = String(kst.getUTCMonth() + 1).padStart(2, "0");
  const d = String(kst.getUTCDate()).padStart(2, "0");
  return `${y}-${m}-${d}`;
}

// 재현 가능한 RNG (mulberry32)
function makeRng(seedNum) {
  let t = seedNum >>> 0;
  return function () {
    t += 0x6D2B79F5;
    let r = Math.imul(t ^ (t >>> 15), 1 | t);
    r ^= r + Math.imul(r ^ (r >>> 7), 61 | r);
    return ((r ^ (r >>> 14)) >>> 0) / 4294967296;
  };
}

// Fisher–Yates shuffle
function shuffle(array, rng = Math.random) {
  const a = [...array];
  for (let i = a.length - 1; i > 0; i--) {
    const j = Math.floor(rng() * (i + 1));
    [a[i], a[j]] = [a[j], a[i]];
  }
  return a;
}

// 원형 매칭
function makeRingPairs(list) {
  return list.map((reviewer, i) => ({
    reviewer,
    reviewee: list[(i + 1) % list.length],
  }));
}

function buildSlackPayload(title, pairs) {
  const lines = pairs.map(p => `• *${p.reviewer}* → ${p.reviewee}`);
  return { text: `${title}\n\n${lines.join("\n")}` };
}

// Slack 전송 (없으면 콘솔 출력)
async function postToSlack(payload, dryRun = false) {
  const url = process.env.SLACK_WEBHOOK_URL;
  if (dryRun || !url) {
    console.log("슬랙 전송 건너뜀(dry-run 또는 WEBHOOK 미설정). 출력:\n");
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

// CLI 인자: --seed=숫자, --dry-run
function parseArgs(argv) {
  const opts = { seed: null, dryRun: false };
  for (const arg of argv.slice(2)) {
    if (arg.startsWith("--seed=")) {
      const v = Number(arg.split("=")[1]);
      if (!Number.isNaN(v)) opts.seed = v;
    } else if (arg === "--dry-run") {
      opts.dryRun = true;
    }
  }
  if (opts.seed === null && process.env.SEED) {
    const v = Number(process.env.SEED);
    if (!Number.isNaN(v)) opts.seed = v;
  }
  if (!opts.dryRun && process.env.DRY_RUN === "1") {
    opts.dryRun = true;
  }
  return opts;
}

// ----------- 메인 -----------
(async () => {
  if (!Array.isArray(members) || members.length < 2) {
    throw new Error("members가 2명 이상 필요합니다.");
  }

  const opts = parseArgs(process.argv);
  const rng = opts.seed !== null ? makeRng(opts.seed) : Math.random;

  const shuffled = shuffle(members, rng);
  const pairs = makeRingPairs(shuffled);

  const label = getKSTDateLabel();
  const payload = buildSlackPayload(`:arrows_clockwise: 코드리뷰어 배정! (${label})`, pairs);

  await postToSlack(payload, opts.dryRun);
  console.log("\n배정 완료:\n" + payload.text);
})();
