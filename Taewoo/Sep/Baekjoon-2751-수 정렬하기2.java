import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			set.add(Integer.valueOf(st.nextToken()));
		}

		List<Integer> list_set = new ArrayList(set);
		Collections.sort(list_set);

		for (int i = 0; i < list_set.size(); i++) {
			bw.write(String.valueOf(list_set.get(i)));
			bw.newLine();
		}

		bw.close();
	}
}
