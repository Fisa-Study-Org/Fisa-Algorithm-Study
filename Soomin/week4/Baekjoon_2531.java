import java.io.*;
import java.util.*;

public class Baekjoon_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1]; // 초밥 종류별 개수
        int unique = 0;

        // 초기 윈도우 세팅
        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) unique++;
            count[belt[i]]++;
        }

        int result = unique + (count[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            int out = belt[i - 1];
            int in = belt[(i + k - 1) % N];

            // 빠지는 초밥
            count[out]--;
            if (count[out] == 0) unique--;

            // 새로 들어오는 초밥
            if (count[in] == 0) unique++;
            count[in]++;

            int current = unique + (count[c] == 0 ? 1 : 0);
            result = Math.max(result, current);
        }

        System.out.println(result);
    }
}
