package fisa_cote.august;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj11660 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// N x N 개의 수(표)
		int M = Integer.parseInt(st.nextToken());	// 합 구할 횟수
		
		int[][] arr = new int[N][N];		// Original 배열
		int[][] sumArr = new int[N+1][N+1];	// 합배열
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] + arr[i-1][j-1] - sumArr[i-1][j-1];
			}
		}
		
	
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int xStart = Integer.parseInt(st.nextToken());
			int yStart = Integer.parseInt(st.nextToken());
			int xEnd = Integer.parseInt(st.nextToken());
			int yEnd = Integer.parseInt(st.nextToken());
			
			int answer = sumArr[xEnd][yEnd] - sumArr[xEnd][yStart-1] - sumArr[xStart-1][yEnd] + sumArr[xStart-1][yStart-1];
			
			sb.append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}
