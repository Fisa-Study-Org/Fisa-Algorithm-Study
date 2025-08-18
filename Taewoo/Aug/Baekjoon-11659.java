import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		int[] num_list = new int[N];
		int[] sum_num_list = new int[N];
		st = new StringTokenizer(br.readLine());
		num_list[0] = Integer.valueOf(st.nextToken());
		sum_num_list[0] = num_list[0];

		for (int i = 1; i < N; i++) {
			num_list[i] = Integer.valueOf(st.nextToken());
			sum_num_list[i] = num_list[i] + sum_num_list[i - 1];
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			
			int result = sum_num_list[end-1] - sum_num_list[start-1] + num_list[start-1]; 
			System.out.println(result);
		}

	}

}
