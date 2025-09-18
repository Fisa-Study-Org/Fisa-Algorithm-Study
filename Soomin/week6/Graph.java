import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 정점의 수 N과 간선의 수 M
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // 인접 리스트를 배열로 만들기. 크기는 N+1 (1부터 N까지)
        int[][] graph = new int[N + 1][N + 1];  // N x N 크기의 2D 배열
        
        // M개의 간선 정보 입력받기
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;  // u와 v가 연결되었음을 표시
            graph[v][u] = 1;  // v와 u가 연결되었음을 표시 (양방향 간선)
        }
        
        // 각 정점에 대해 연결된 정점들을 출력
        for (int i = 1; i <= N; i++) {
            // 해당 정점과 연결된 정점들 출력
            System.out.print(i);
            boolean isFirst = true;  // 첫 번째 연결 정점 표시용 변수
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1) {  // i와 j가 연결되어 있다면
                    if (isFirst) {
                        System.out.print(" " + j);  // 첫 번째 연결점은 그냥 출력
                        isFirst = false;
                    } else {
                        System.out.print(" " + j);  // 그 외의 연결점들도 출력
                    }
                }
            }
            System.out.println();  // 한 줄 끝내기
        }

        sc.close();
    }
}
