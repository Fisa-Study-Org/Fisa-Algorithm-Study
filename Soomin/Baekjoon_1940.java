import java.io.*;
import java.util.*;

public class Baekjoon_1940 {
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

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int target = M - num;
            if (map.getOrDefault(target, 0) > 0) {
                count++;
                map.put(target, map.get(target) - 1); 
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}

