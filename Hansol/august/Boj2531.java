package fisa_cote.august;

import java.io.*;
import java.util.*;

public class Boj2531 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//접시수
		int d = Integer.parseInt(st.nextToken());	//가짓수
		int k = Integer.parseInt(st.nextToken());	//연속접시수
		int c = Integer.parseInt(st.nextToken());	//쿠폰번호
		
		int[] sushi = new int[N+k];
		
		
		// 레일 펼치기
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = N; i < N+k; i++) {
			sushi[i] = sushi[i-N];
		}
		

		int[] check = new int[d+1];
		int answer = 0;
		int sum = 0;
		
		for(int i = 0; i < k; i++) {
			if(check[sushi[i]] == 0) sum++;
			check[sushi[i]]++;
		}
		
		if(check[c] == 0) {
			answer = sum+1;
		}else {
			answer = sum;
		}
		
		int start = 0;
		int end = k;
		
		while(end < N+k) {
			if(check[sushi[end++]]++ == 0) sum++;
			if(check[sushi[start++]]-- == 1) sum--;
			if(check[c] == 0) {
				answer = Math.max(sum+1, answer);
			}else {
				answer = Math.max(sum, answer);
			}
		}
		
		
		System.out.println(answer);
		
	}
}
