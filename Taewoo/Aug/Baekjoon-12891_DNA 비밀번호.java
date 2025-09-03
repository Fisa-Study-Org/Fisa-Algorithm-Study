import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n, m = 0;
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		char[] dna_arr = br.readLine().toCharArray();

		int[] dna_count = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			dna_count[i] = Integer.valueOf(st.nextToken());
		}

		Deque<Character> dq = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			dq.add(dna_arr[i]);
		}

		int count = 0;
		int[] dna_count_copy = Arrays.copyOf(dna_count, dna_count.length);
		for (char c : dq) {
			if (c == 'A') {
				dna_count_copy[0]--;
			} else if (c == 'C') {
				dna_count_copy[1]--;
			} else if (c == 'G') {
				dna_count_copy[2]--;
			} else if (c == 'T') {
				dna_count_copy[3]--;
			}
		}

		if (dna_count_copy[0] <= 0 && dna_count_copy[1] <= 0 && dna_count_copy[2] <= 0 && dna_count_copy[3] <= 0) {
			count++;
		}

		char ch;
		for (int i = m; i < n; i++) {
			ch = dq.getFirst();
			if (ch == 'A') {
				dna_count_copy[0]++;
			} else if (ch == 'C') {
				dna_count_copy[1]++;
			} else if (ch == 'G') {
				dna_count_copy[2]++;
			} else if (ch == 'T') {
				dna_count_copy[3]++;
			}
			dq.poll();

			dq.add(dna_arr[i]);
			ch = dna_arr[i];

			if (ch == 'A') {
				dna_count_copy[0]--;
			} else if (ch == 'C') {
				dna_count_copy[1]--;
			} else if (ch == 'G') {
				dna_count_copy[2]--;
			} else if (ch == 'T') {
				dna_count_copy[3]--;
			}
			if (dna_count_copy[0] <= 0 && dna_count_copy[1] <= 0 && dna_count_copy[2] <= 0 && dna_count_copy[3] <= 0) {
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.close();
	}
}
