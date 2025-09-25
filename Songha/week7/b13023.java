package algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b13023 {
	static boolean isTrue;
	static boolean visited [];
	static ArrayList<Integer>[] A;
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 n = Integer.parseInt(st.nextToken()); // 친구 갯수
		 m = Integer.parseInt(st.nextToken()); // 친구 관계 수
	
		
		visited = new boolean[n+1];
		A = new ArrayList[n+1];
		
		for (int i = 0; i < n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// 배열 만들기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 사람
			int e = Integer.parseInt(st.nextToken()); // 관계
			
			A[s].add(e);
			A[e].add(s);
		}
		
		// backtraking	
		for (int i = 0; i < n; i++) {
			if(!isTrue) {
				backtraking(i, 0);
			}
			
		}
		
		
		System.out.println(isTrue ? "1": "0");
		
	}

	private static void backtraking(int v, int depth) {
		
		// 정답
		if(depth == 4) {
			isTrue = true;
			return;
		}

		visited[v] = true;
		for (int i : A[v]) {
			if(!visited[i]) {
				backtraking(i , depth+1);
			}
		}

		visited[v] = false;
		
	}


}
