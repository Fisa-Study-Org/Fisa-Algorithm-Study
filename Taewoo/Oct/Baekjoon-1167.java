package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static ArrayList<int[]>[] graph;
	static boolean[] vistied;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int u, v;
		int value;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.valueOf(st.nextToken());
			value = Integer.valueOf(st.nextToken());
			v = Integer.valueOf(st.nextToken());

			graph[u].add(new int[] { v, value });
		}
	}

	public static void bfs(int node) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int next_node = queue.poll();
			for (int[] neighbor : graph[next_node]) {
				int neighbor_node = neighbor[0];
				queue.add(neighbor_node);
				
			}
		}
	}
}