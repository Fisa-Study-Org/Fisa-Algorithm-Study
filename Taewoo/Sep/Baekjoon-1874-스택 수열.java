import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int[] num_arr = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num_arr[i] = Integer.valueOf(st.nextToken());
		}

		int number = 1;
		int index = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		ArrayList<Character> result = new ArrayList<>();

		while (index < n) {
			if (dq.isEmpty() || !dq.peekFirst().equals(num_arr[index])) {
				if (number > n)
					break;
				dq.addFirst(number);
				result.add('+');
				number++;
			} else {
				dq.pop();
				result.add('-');
				index++;
			}
		}

		if (index == n) {
			for (char c : result) {
				bw.write(c);
				bw.write('\n');
			}
		} else {
			bw.write("NO");
		}
		bw.flush();
		bw.close();
	}
}
