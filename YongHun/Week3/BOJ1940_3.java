import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] num = new boolean[100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[Integer.parseInt(st.nextToken())] = true;
		}
		
		int sum = 0;
		
		for(int i=1; i<=M/2; i++) {
			if(i==M-i || M-i>100000) continue;
			if(num[i] && num[M-i]) {
				sum++;
			}
		}
		
		bw.write(sum+"");
		bw.close();
	}
}
