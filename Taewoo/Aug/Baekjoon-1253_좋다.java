import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] num_arr = new int[n];
		for (int i = 0; i < n; i++) {
			num_arr[i] = Integer.valueOf(st.nextToken());
		}
		
		if (n < 3) {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}

		Arrays.sort(num_arr);

		int start, end, sum, count = 0;

		for (int i = 0; i < n; i++) {
			start = 0;
			end = n - 1;

			while (start < end) {
				if (start == i) {
					start++;
					continue;
				}
				if (end == i) {
					end--;
					continue;
				}

				sum = num_arr[start] + num_arr[end];

				if (sum == num_arr[i]) {
					count++;
					break;
				} else if (sum > num_arr[i]) {
					end--;
				} else {
					start++;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
