package algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2164 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= input; i++) {
			queue.offer(i);
		}

		for (int i = 1; i <= input; i++) {

			if (queue.size() == 1) break;

			if (i == 1) {
				queue.poll(); // 첫번째 값 제거
			} else {
				queue.offer(queue.peek()); // 뒤로 추가
				queue.poll(); // 앞에 있던 값 제거

				queue.poll(); // 이동 후 앞에 있는 값 제거

			}

		}

		System.out.println(queue.peek());
	}

}
