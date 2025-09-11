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

        Stack<Integer> stack = new Stack<>();

        int start = 1;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            for(int s=start; s<=num; s++) {
                stack.push(s);
                sb.append("+\n");
                start++;
            }

            if(stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            }
        }

        System.out.println(stack.isEmpty() ? sb.toString() : "NO");
    }
}