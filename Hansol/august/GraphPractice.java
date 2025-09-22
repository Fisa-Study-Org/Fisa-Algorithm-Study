package fisa_cote.august;

import java.util.*;
import java.io.*;


public class GraphPractice {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			bw.write(i + " ");
			for(int num : list.get(i)) {
				bw.write(num + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
