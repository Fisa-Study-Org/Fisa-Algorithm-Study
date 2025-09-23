package fisa_cote.august;

import java.util.*;
import java.io.*;

public class Boj2023 {
	
	static int N, count;
	static double digits;
	static int[] sosu = {2, 3, 5, 7};
	static int[] plus = {1, 3, 7, 9};
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		digits = Math.pow(10, N);
		
		for(int i = 0; i < 4; i++) {
			count = 1;
			dfs(sosu[i],1);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}


	private static void dfs(int num, int count) {
		if(check(num)) {
			if(count == N) {
				sb.append(num).append("\n");
				return;
			}
			for(int i = 0; i < 4; i++) {
				dfs(10*num+plus[i], count+1);
			}
		}else {
			return;
		}
	}
	
	private static boolean check(int num) {
		int devide = 2;
		while(devide*devide <= num) {
			if(num % devide == 0) {
				return false;
			}
			devide++;
		}
		return true;
	}
}
