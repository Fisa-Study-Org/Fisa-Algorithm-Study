import java.util.*;

public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		String number = sc.nextLine();
		
		int sum = 0;
		int num = 0;

		for (int i = 0; i<number.length(); i ++) {
			char ch = number.charAt(i);
			num = ch - '0';
			sum+=num;
		}
		
		System.out.println(sum);
	}
}
