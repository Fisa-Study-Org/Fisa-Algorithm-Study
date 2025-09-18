import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int dish = Integer.valueOf(st.nextToken());
		int sushi = Integer.valueOf(st.nextToken());
		int eating_dish = Integer.valueOf(st.nextToken());
		int coupon = Integer.valueOf(st.nextToken());

		int[] dish_arr = new int[dish];

		for (int i = 0; i < dish; i++) {
			st = new StringTokenizer(br.readLine());
			dish_arr[i] = Integer.valueOf(st.nextToken());
		}

		Deque<Integer> dq = new ArrayDeque<>();
		int[] dish_total = new int[sushi + 1];
		int count = 0;
		List<Integer> count_list = new ArrayList<>();

		for (int i = 0; i < eating_dish; i++) {
			if (dish_total[dish_arr[i]] == 0) {
				dish_total[dish_arr[i]]++;
				count++;
			} else {
				dish_total[dish_arr[i]]++;
			}
			dq.addLast(dish_arr[i]);
		}

		int cupon_count = count;
		if (dish_total[coupon] == 0) {
			cupon_count++;
		}
		count_list.add(cupon_count);

		for (int i = eating_dish; i < dish + eating_dish; i++) {

			int out_value = dq.getFirst();
			dq.removeFirst();
			dish_total[out_value]--;
			if (dish_total[out_value] == 0) {
				count--;
			}

			int in_value = dish_arr[i % dish];
			if (dish_total[in_value] == 0) {
				dish_total[in_value]++;
				count++;
			} else {
				dish_total[in_value]++;
			}
			dq.addLast(in_value);

			cupon_count = count;
			if (dish_total[coupon] == 0) {
				cupon_count++;
			}

			count_list.add(cupon_count);
		}
		bw.write(String.valueOf(Collections.max(count_list)));
		bw.close();
	}
}
