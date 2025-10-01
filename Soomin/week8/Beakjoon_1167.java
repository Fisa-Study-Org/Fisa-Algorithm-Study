import java.io.*;
import java.util.*;

public class Beakjoon_1167 {
    static int V;
    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int farthestNode;   
    static int maxDistance;    

    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine().trim());
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[from].add(new Edge(to, w));
            }
        }

        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[V + 1];
        visited[farthestNode] = true;
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int cur, int dist) {
        if (dist > maxDistance) {
            maxDistance = dist;
            farthestNode = cur;
        }
        for (Edge e : tree[cur]) {
            if (!visited[e.to]) {
                visited[e.to] = true;
                dfs(e.to, dist + e.weight);
            }
        }
    }
}
