import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
    	int N = Integer.parseInt(br.readLine());
    	
    	Stack<int[]> stack = new Stack<>();
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int[] answer = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		while(!stack.isEmpty()) {
        		if(stack.peek()[1] < num) {
        			answer[stack.pop()[0]] = num;
        		} else {
        			break;
        		}
    		}
    		
    		stack.push(new int[] {i, num});
    	}
    	
    	while(!stack.isEmpty()) {
    		answer[stack.pop()[0]] = -1;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++) {
    		sb.append(answer[i]+" ");
    	}
    	bw.write(sb.toString());
    	bw.close();
    }
}