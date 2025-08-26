package fisa_cote.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1253 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num)
		
		for(int result = 0; result < N; result++) {
			int start = 0;
			int end = N-1;
			while(start < end) {
				if(end  == result) {	// 더하는 두 수에 자기가 포함이면
					end--;
					continue;
				}else if(start == result) {
					start++;
					continue;
				}
				int tmp = num[start] + num[end];
				if(tmp == num[result]) {
					answer++;
					break;
				}else if(tmp < num[result]) {
					start++;
				}else {
					end--;
				}
			}
		}
		
		System.out.println(answer);
	}
}
