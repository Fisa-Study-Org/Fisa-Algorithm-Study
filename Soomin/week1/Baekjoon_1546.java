import java.util.Scanner;

public class Baekjoon_1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] scores = new double[n];
        
        double max = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (scores[i] / max) * 100;
        }

        System.out.println(sum / n);

        sc.close();

	}

}
