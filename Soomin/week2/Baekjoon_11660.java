package week01;
import java.util.Scanner;

public class Baekjoon_11660 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  
        int M = sc.nextInt();  
        int[][] matrix = new int[N+1][N+1];  
        int[][] prefix = new int[N+1][N+1];  
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix[i][j] = matrix[i][j] 
                               + prefix[i-1][j] 
                               + prefix[i][j-1] 
                               - prefix[i-1][j-1];
            }
        }
        
        for (int k = 0; k < M; k++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            int sum = prefix[x2][y2]
                    - prefix[x1-1][y2]
                    - prefix[x2][y1-1]
                    + prefix[x1-1][y1-1];
            
            System.out.println(sum);
        }

        sc.close();
    }
}
