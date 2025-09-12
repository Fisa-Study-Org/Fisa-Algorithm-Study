import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 1; i < n + 1; i++) {
			dq.addLast(i);
		}

		int tmp;
		while (dq.size() != 1) {
			dq.removeFirst();
			tmp = dq.removeFirst();
			dq.addLast(tmp);
		}

		bw.write(String.valueOf(dq.removeFirst()));
		bw.close();

	}
}
