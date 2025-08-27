import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();

		int[] arr = new int[num];

		int score = 0;
		for (int i = 0; i < num; i++) {
			score = sc.nextInt();
			arr[i] = score;
		}

		int max = Arrays.stream(arr).max().getAsInt();

		double mean = 0;
		for (int number : arr) {
			mean += ((double)number / (max)*100);
		}
		System.out.println(mean/num);

	}
}
