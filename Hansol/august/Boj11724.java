package fisa_cote.august;

import java.util.*;
import java.io.*;

public class Boj11724 {
	static int N, M;
	static boolean[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int count = 0;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				count++;
				visited[i] = true;
				dfs(i);
			}
		}
		
		System.out.println(count);
		
	}

	private static void dfs(int num) {
		for(int i : list[num]) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
