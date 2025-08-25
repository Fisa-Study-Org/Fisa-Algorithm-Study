import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		int sum = 0;
		int front = 0;
		int rear = N-1;
		
		while(front<rear) {
			int now = arr[front] + arr[rear];
			
			if(now == M) {
				sum++;
				front++;
				rear--;
			} else if(now < M) {
				front++;
			} else {
				rear--;
			}
		}
		
		bw.write(sum+"");
		bw.close();
	}
}
