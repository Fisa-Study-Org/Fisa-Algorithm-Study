import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            q.offer(i);
        }

        if(N==1) {
            System.out.println(1);
            return;
        }

        q.poll();
        while(q.size() > 1) {
            q.offer(q.poll());
            q.poll();
        }

        System.out.println(q.poll());
    }
}