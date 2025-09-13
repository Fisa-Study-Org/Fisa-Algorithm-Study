import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main
{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        StringBuilder sb = new StringBuilder();
        for(int n=1; n<=N; n++) {
            sb.append(n + " ");
            for(int i=0; i<graph[n].size(); i++) {
                sb.append(graph[n].get(i) + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}