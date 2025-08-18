package fisa_cote.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11720{
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		int sum = 0;
		for(char c : arr) {
			int tmp = (int)(c-'0');
			sum += tmp;
		}
		System.out.println(sum);
		
		br.close();
	}
}
