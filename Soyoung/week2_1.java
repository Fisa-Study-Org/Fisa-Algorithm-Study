import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //집합 크기 n, 합 개수 m 받아오기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //그때그때 입력받으면 runtimeerror 뜸
        // 그래서 미리 합을 구해놓으면 편함

        //arr은 집합 저장 배열 pre_sum은 누적합 저장 배열
        int[] arr = new int[n + 1];
        int[] pre_sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        //집합 누적합 계산
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pre_sum[i] = pre_sum[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int sum = pre_sum[q] - pre_sum[j - 1];
            System.out.println(sum);
        }
    }

}
