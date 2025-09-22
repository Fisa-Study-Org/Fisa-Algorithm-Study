import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    static boolean answer;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	ArrayList<Integer>[] graph = new ArrayList[N];
    	for(int i=0; i<N; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		
    		graph[u].add(v);
    		graph[v].add(u);
    	}
    	
    	boolean[] visited = new boolean[N];
    	for(int i=0; i<N; i++) {
    		DFS(graph, visited, 1, i);
    		if(answer) break;
    	}
    	
    	bw.write(answer?'1':'0');
    	bw.close();
    }
    
    static void DFS(ArrayList<Integer>[] graph, boolean[] visited, int friends, int now) {
    	if(friends == 5 || answer) {
    		answer = true;
    		return;
    	}

		visited[now] = true;
    	for(int i=0; i<graph[now].size(); i++) {
    		int next = graph[now].get(i);
    		
    		if(!visited[next]) {
    			DFS(graph, visited, friends+1, next);
    		}
    	}
		visited[now] = false;
    }
}