package fisa_cote.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] dna = br.readLine().toCharArray();
		
		
		int[] acgt = new int[26];
		
		
		st = new StringTokenizer(br.readLine());
		acgt[0] = Integer.parseInt(st.nextToken());
		acgt[2] = Integer.parseInt(st.nextToken());
		acgt[6] = Integer.parseInt(st.nextToken());
		acgt[19] = Integer.parseInt(st.nextToken());
		
		

		int[] tmp = new int[26];
		int answer = 0;
		int start = 0;
		int end = P;
		
		
		for(int i = 0; i < P; i++) {
			int now = (int)(dna[i]-'A');
			tmp[now]++;
		}
		
		if(check(tmp, acgt)) answer++;
		
		
		while(end < S) {
			tmp[(int)(dna[start++]-'A')]--;
			tmp[(int)(dna[end++]-'A')]++;
			if(check(tmp, acgt)) answer++;
		}
		
		
		
		System.out.println(answer);
	}
	
	static boolean check(int[] a, int[] b) {
		if(a[0] >= b[0] && a[2] >= b[2] && a[6] >= b[6] && a[19] >= b[19]) return true;
		return false;
	}
}
