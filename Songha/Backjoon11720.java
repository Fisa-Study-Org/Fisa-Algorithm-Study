package algorithm;

import java.util.Scanner;

public class Backjoon11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int totalInputCount = sc.nextInt();
		String values = sc.next();

		int count = 0;

		for (int i = 0; i < totalInputCount; i++) {
			count += Character.getNumericValue(values.charAt(i));

		}

		System.out.println(count);

	}

}
