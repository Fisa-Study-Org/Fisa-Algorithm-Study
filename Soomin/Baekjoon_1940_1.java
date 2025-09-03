import java.io.*;
import java.util.*;

public class Baekjoon_1940_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 재료 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷이 되는 번호의 합

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 투 포인터를 위해 정렬

        int left = 0, right = N - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == M) {
                count++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
