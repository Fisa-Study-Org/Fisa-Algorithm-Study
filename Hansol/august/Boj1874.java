package fisa_cote.august;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boj1874 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		List<Character> list = new ArrayList<Character>();
		int index = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int num = 1; num <= N; num++) {
			stack.push(num);
			list.add('+');
			while(stack.peek() == arr[index]) {
				stack.pop();
				list.add('-');
				index++;
				if(stack.isEmpty())break;
			}
		}
		
		if(stack.isEmpty()) {
			for(char i : list) {
				sb.append(i).append("\n");
			}
		}else {
			sb.append("NO");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
