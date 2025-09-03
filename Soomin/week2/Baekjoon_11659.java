package week01;

import java.util.Scanner;

public class Baekjoon_11659 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N: 배열의 크기, M: 구간의 개수
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N + 1];
		int[] prefixSum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			System.out.println(prefixSum[end] - prefixSum[start - 1]);
		}

		sc.close();
	}

}
