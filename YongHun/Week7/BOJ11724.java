import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	ArrayList<Integer>[] graph = new ArrayList[N+1];
    	for(int i=1; i<=N; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		
    		graph[u].add(v);
    		graph[v].add(u);
    	}
    	
    	boolean[] visited = new boolean[N+1];
    	int answer = 0;
    	
    	for(int i=1; i<=N; i++) {
    		if(!visited[i]) {
    			DFS(graph, visited, i);
    			answer++;
    		}
    	}
    	
    	bw.write(String.valueOf(answer));
    	bw.close();
    }
    
    public static void DFS(ArrayList<Integer>[] graph, boolean[] visited, int now) {
		visited[now] = true;
		
    	for(int i=0; i<graph[now].size(); i++) {
    		int next = graph[now].get(i);
    		
    		if(!visited[next])
    			DFS(graph, visited, next);
    	}
    }
}