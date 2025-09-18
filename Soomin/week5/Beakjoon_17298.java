import java.io.*;
import java.util.*;

public class Beakjoon_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 오른쪽에서 왼쪽으로 탐색
        for (int i = n - 1; i >= 0; i--) {
            // 스택에서 현재 값보다 작거나 같은 수는 제거
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // 스택이 비었으면 오큰수가 없음
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                // 스택의 top이 오큰수
                answer[i] = stack.peek();
            }

            // 현재 값 스택에 push
            stack.push(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
