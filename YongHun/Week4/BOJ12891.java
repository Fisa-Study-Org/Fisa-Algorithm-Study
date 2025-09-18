import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int A = 'A'-'A';
        int C = 'C'-'A';
        int G = 'G'-'A';
        int T = 'T'-'A';

        int answer = 0;

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int[] min = new int[26];
        st = new StringTokenizer(br.readLine());

        min[A] = Integer.parseInt(st.nextToken());
        min[C] = Integer.parseInt(st.nextToken());
        min[G] = Integer.parseInt(st.nextToken());
        min[T] = Integer.parseInt(st.nextToken());

        int[] DNA = new int[26];
        for(int i=0; i<P; i++) {
            DNA[str.charAt(i)-'A']++;
        }
        if(DNA[A]>=min[A] && DNA[C]>=min[C] && DNA[G]>=min[G] && DNA[T]>=min[T]) {
            answer++;
        }

        int front = 0;
        int rear = P;

        while(rear<S) {
            DNA[str.charAt(front)-'A']--;
            DNA[str.charAt(rear)-'A']++;
            front++;
            rear++;
            if(DNA[A]>=min[A] && DNA[C]>=min[C] && DNA[G]>=min[G] && DNA[T]>=min[T]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}