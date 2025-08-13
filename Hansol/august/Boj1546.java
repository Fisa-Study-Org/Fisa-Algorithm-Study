package fisa_cote.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		int[] oldGrade = new int[N];
		double sum = 0.0;
		int maxGrade = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			oldGrade[i] = Integer.parseInt(st.nextToken());
			maxGrade = Math.max(maxGrade, oldGrade[i]);
		}
		
		for(int i = 0; i < N; i++) {
			sum+= (double)oldGrade[i]/maxGrade*100;
		}
		
		System.out.println(sum/N);
		br.close();
		
	}
}
