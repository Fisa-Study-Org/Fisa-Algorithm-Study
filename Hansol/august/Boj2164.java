package fisa_cote.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2164 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			cards.add(i);
		}
		
		while(cards.size() > 1) {
			cards.poll();
			int tmp = cards.poll();
			cards.add(tmp);
		}
		
		System.out.println(cards.poll());
	}
}
