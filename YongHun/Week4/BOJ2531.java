import java.io.*;
import java.util.StringTokenizer;

class Main
{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 접시
        int d = Integer.parseInt(st.nextToken());   // 초밥범위(1~d)
        int k = Integer.parseInt(st.nextToken());   // 연속접시수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 초밥번호

        int[] rail = new int[N];

        for(int i=0; i<N; i++) {
            rail[i] = Integer.parseInt(br.readLine());
        }

        int[] eat = new int[d+1];
        int plate = 0;

        for(int i=0; i<k; i++) {
            int no = rail[i%N];
            if(eat[no] == 0) {
                plate++;
            }
            eat[no]++;
        }

        int front = 0;
        int rear = k;
        int answer = 0;

        for(int i=0; i<N; i++) {
            answer = Math.max(answer, eat[c]==0 ? plate+1 : plate);

            eat[rail[front%N]]--;
            if(eat[rail[front%N]] == 0) {
                plate--;
            }
            if(eat[rail[rear%N]] == 0) {
                plate++;
            }
            eat[rail[rear%N]]++;
            front++;
            rear++;
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}