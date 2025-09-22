package fisa_cote.august;

import java.io.*;
import java.util.*;

public class Boj13023 {
	
	static int N, M, isEixst;
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		isEixst = 0;
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			DFS(i,0);
			visited[i] = false;
		}
		
		System.out.println(isEixst);
	
	}
	
	
	private static void DFS(int num, int count) {
		if(isEixst == 1) return;
		
		if(count == 4) {
			isEixst = 1;
			return;
		}else {
			for(int i : list[num]) {
				if(!visited[i]) {
					visited[i] = true;
					DFS(i, count+1);
					visited[i] = false;
				}
			}
		}
	}
}
