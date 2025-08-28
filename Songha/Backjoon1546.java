package algorithm;
import java.util.Scanner;
import java.util.Arrays;

public class Backjoon1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totalInputCount = sc.nextInt();
		
		int[] valueList = new int[totalInputCount];
		double[] resultList = new double[totalInputCount];
		
		// 입력
		for (int i = 0; i < totalInputCount; i++) {
			valueList[i] = sc.nextInt();
		}
		

		int maxNm = Arrays.stream(valueList).max().getAsInt();
		for (int i = 0; i < totalInputCount; i++) {
			resultList[i] =(double) valueList[i] / maxNm * 100;
		}
		
		System.out.printf("%.2f",Arrays.stream(resultList).average().orElse(0.0));
		
	}

}
