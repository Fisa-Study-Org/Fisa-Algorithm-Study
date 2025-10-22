import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //한 줄에서 같이 읽어야 함
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        
        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        int max = 0;
        int sum = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int left = max;  // 최소 블루레이 크기
        int right = sum; // 최대 
        int answer = sum;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int current = 0;

            for (int time : arr) {
                if (current + time > mid) {
                    count++;
                    current = 0;
                }
                current += time;
            }

            if (count > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
