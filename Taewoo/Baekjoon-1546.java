package baekjoon;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = 0;
		int sum = 0;
		boolean no_group_word = false;
		String word = "";
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			word = sc.next();

			for (int j = 0; j < word.length(); j++) {
				int index_reverse = word.length() - 1;

				if (no_group_word) {
					break;
				} // 만약 group_word가 아니면 그만둠

				while (index_reverse > j) {
					if (no_group_word) {
						break;
					}

					if (word.charAt(j) == word.charAt(index_reverse)) {
						for (int k = j; k < index_reverse; k++) {
							if (word.charAt(j) != word.charAt(k)) {
								no_group_word = true;
								break;
							}
						}
					}
					index_reverse-=1;
				}
			}
			if (no_group_word) {
				no_group_word = false;
			} else {
				sum += 1;
			}
		}
		System.out.println(sum);
	}
}
