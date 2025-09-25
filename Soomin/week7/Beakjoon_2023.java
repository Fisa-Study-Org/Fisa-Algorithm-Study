import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon_2023 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        // 1자리 소수부터 시작
        int[] firstPrimes = {2, 3, 5, 7};
        for (int p : firstPrimes) {
            dfs(p, 1);
        }
    }

    static void dfs(int cur, int depth) {
        if (depth == N) {
            System.out.println(cur);
            return;
        }

        for (int d = 1; d <= 9; d += 2) {
            int next = cur * 10 + d;
            if (isPrime(next)) { 
                dfs(next, depth + 1);
            }
        }
    }

    static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}