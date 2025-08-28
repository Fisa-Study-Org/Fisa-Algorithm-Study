import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static class Nums {
		String num;
		int k;
		Nums(String num, int k) {
			this.num = num;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		int answer = -1;
		
		boolean[][] visited = new boolean[K+1][1000001];
		Queue<Nums> q = new LinkedList<>();
		q.add(new Nums(str, 0));
		visited[0][Integer.parseInt(str)] = true;
		
		while(!q.isEmpty()) {
			Nums n = q.poll();
			
			if(n.k == K) {
				answer = Math.max(answer, Integer.parseInt(n.num));
			}
			else {
				for(int i=0; i<n.num.length()-1; i++) {
					for(int j=i+1; j<n.num.length(); j++) {
						if(i == 0 && n.num.charAt(j) == '0') {
							continue;
						}

						char[] charr = n.num.toCharArray();
						
						char ch = charr[i];
						charr[i] = charr[j];
						charr[j] = ch;
						
						String temp = new String(charr);
						
						if(!visited[n.k+1][Integer.parseInt(temp)]) {
							visited[n.k+1][Integer.parseInt(temp)] = true;
							q.add(new Nums(temp, n.k+1));
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
