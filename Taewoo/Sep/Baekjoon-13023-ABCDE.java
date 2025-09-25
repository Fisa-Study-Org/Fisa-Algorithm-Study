import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static boolean is_true = false;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			dfs(i, count);
			count = 0;
		}

		if (is_true) {
			bw.write("1");
			bw.close();
		} else {
			bw.write("0");
			bw.close();
		}

	}

	public static void dfs(int node, int count) {
		visited[node] = true;
		if (count == 4) {
			is_true = true;
			return;
		}

		for (int neighbor : graph[node]) {
			if (!visited[neighbor]) {
				dfs(neighbor, count + 1);
			}
		}
		visited[node] = false;
	}
}
