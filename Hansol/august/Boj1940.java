package fisa_cote.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1940 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 재료의 개수
		int M = Integer.parseInt(br.readLine());	// 갑옷 합
		int answer = 0;	// 답
		
		int ingre[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			ingre[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ingre);
		
		int start = 0;
		int end = N-1;
		int tmp = 0;
		
		while(start < end) {
			tmp = ingre[start] + ingre[end];
			if(tmp == M) {
				answer++;
				start++;
				end--;
			}else if(tmp > M) {
				end--;
			}else {
				start++;
			}
		}
		
		System.out.println(answer);
		
		
	}
}
