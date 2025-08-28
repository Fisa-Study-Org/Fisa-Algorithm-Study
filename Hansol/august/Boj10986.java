package fisa_cote.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 수
		int M = Integer.parseInt(st.nextToken());	// 나눌 수
		
		long answer = 0;	//답
		
		long[] sumArr = new long[N+1];	//합배열
		int[] devideArr = new int[N+1];	//나머지배열
		int[] countArr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			devideArr[i] = (int)(sumArr[i] % M);
			if(devideArr[i] == 0) answer++;	// 합구간 나머지 0인부분 -> 답
			countArr[devideArr[i]]++;

		}
		
		for(int i = 0; i < M; i++) {
			answer += ((long)countArr[i]*(countArr[i]-1))/2;
		}
		
		System.out.println(answer);
		
	}
}
