package fisa_cote.august;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj11659 {
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());	// 수의 갯수
		int M = Integer.parseInt(st.nextToken());	// 반복 횟수
		
		int[] origin = new int[N];	// 기존 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
		
		
		long[] sum = new long[N+1];	// 합 배열
		
		sum[0] = 0;	// 시작구간이 1일경우 대비하여 0 셋팅
		sum[1] = origin[0];	// 첫번째 수까지의 합 셋팅
		
		for(int i = 2; i <= N; i++) {
			sum[i] = sum[i-1] + origin[i-1];	// N번째 까지의 누적합 셋팅
		}
		
		
		
		while(M-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// 시작구간
			int b = Integer.parseInt(st.nextToken());	// 끝구간
			
			sb.append(sum[b]-sum[a-1]).append("\n");	// 끝구간까지의 합에서 시작구간까지의 합 빼기
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}





