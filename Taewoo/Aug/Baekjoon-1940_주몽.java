import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int m = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// map에 key-value로 넣고, 배열 만들기
		// m에서 해당 값을 뺀 값의 key가 있는 경우 count +=1
		// m에서 해당 값을 뺀 값의 key가 없는 경우 continue;

		int[] num_list = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int num = 0;

		for (int i = 0; i < n; i++) {
			num = Integer.valueOf(st.nextToken());
			num_list[i] = num;
			map.put(num, num);
		}

		for (int i : num_list) {
			if (map.containsKey(m - i)) {
				count += 1;
			}
		}
		bw.write(String.valueOf(count / 2));
		bw.flush();
		bw.close();
	}
}
