import java.io.*;
import java.util.*;

public class Beakjoon_13023 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); 
        }

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            dfs(i, 1);

            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    static void dfs(int current, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[current] = true;

        for (int next : graph[current]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (found) return; 
            }
        }

        visited[current] = false;
    }
}
