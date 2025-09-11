package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {

	public static void main(String[] args)  throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int length = Integer.parseInt(br.readLine()); // 수열 길이

	        Stack<Integer> stack = new Stack<>();
	        StringBuilder sb = new StringBuilder();

	        int current = 1;
	        boolean possible = true;

	        for (int i = 0; i < length; i++) {
	            int target = Integer.parseInt(br.readLine()); // 목표 숫자
	            
	            while(current <= target) {
	            	stack.push(current++);
	            	sb.append("+\n");
	            }
	            
	            if(stack.peek() == target) {
	            	stack.pop();
	            	sb.append("-\n");
	            }else {
	            	possible = false;
	            	break;
	            }
	         
	        }
	        
	        System.out.println(possible ? sb : "NO");

	       
	    }

}
