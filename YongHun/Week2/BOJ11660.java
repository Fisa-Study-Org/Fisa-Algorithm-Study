import java.io.*;
import java.util.StringTokenizer;

public class BOJ11660 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Pos {
		int y;
		int x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());

				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + num;
			}
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Pos end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			int answer = dp[end.y][end.x] - (dp[end.y][start.x-1] + dp[start.y-1][end.x] - dp[start.y-1][start.x-1]);
			
			bw.write(answer + "\n");
		}
		
		bw.close();
	}
}
