import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static ArrayList<Integer> result_list;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		int count = 1;
		result_list = new ArrayList<>();
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);

		while (!result_list.isEmpty()) {
			bw.write(String.valueOf(result_list.remove(0)) + "\n");
		}
		bw.close();
	}

	public static void dfs(int num, int count) {
		if (!is_prime(num)) {
			return;
		}

		if (count == n) {
			result_list.add(num);
			return;
		}

		for (int i = 0; i < 10; i++) {
			int nextNum = 10 * num + i;
			dfs(nextNum, count + 1);
		}
		count = 1;
	}

	public static boolean is_prime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
