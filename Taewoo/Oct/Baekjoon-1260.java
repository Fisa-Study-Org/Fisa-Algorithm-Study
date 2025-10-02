import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int V = Integer.valueOf(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		int u;
		int v;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.valueOf(st.nextToken());
			v = Integer.valueOf(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		dfs(V);

		visited = new boolean[N + 1];
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(V);
		visited[V] = true;

		bw.write("\n");

		int node;
		while (!queue.isEmpty()) {
			node = queue.poll();
			bw.write(String.valueOf(node) + " ");
			for (int neighbor : graph[node]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}

		bw.close();

	}

	public static void dfs(int node) throws IOException {
		visited[node] = true;
		bw.write(String.valueOf(node) + " ");

		for (int neighbor : graph[node]) {
			if (!visited[neighbor]) {
				dfs(neighbor);
			}
		}
	}
}