import java.io.*;
import java.util.*;

public class Baekjoon_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int current = 1;
        boolean isPossible = true;

        // 수열의 각 숫자(target)를 순서대로 처리
        for (int i = 0; i < n; i++) {
            int target = sequence[i];

            // 현재 target 값까지 push
            while (current <= target) {
                stack.push(current++); // current 값을 스택에 push하고 1 증가
                result.append("+\n"); // push한 경우 +
            }

            // 스택의 top이 target과 같다면 pop 수행
            if (stack.peek() == target) {
                stack.pop();
                result.append("-\n"); // pop한 경우 -
            } else {
                // 스택의 top이 target이 아니라면 수열 생성 불가능
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            bw.write(result.toString()); 
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}