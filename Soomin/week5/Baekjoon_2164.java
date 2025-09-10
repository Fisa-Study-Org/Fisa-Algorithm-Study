import java.io.*;
import java.util.*;

public class Baekjoon_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지 큐에 넣기
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (queue.size() > 1) {
            queue.poll(); // 제일 위 카드 버리기
            queue.offer(queue.poll()); // 다음 카드 맨 뒤로 이동
        }

        // 마지막 남은 카드 출력
        bw.write(queue.peek() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}