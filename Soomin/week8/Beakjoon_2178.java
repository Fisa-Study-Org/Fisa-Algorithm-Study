package week8;

import java.io.*;
import java.util.*;

public class Beakjoon_2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;


    static int[] dRow = { -1, 1, 0, 0 };
    static int[] dCol = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    static int bfs(int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];


            if (r == N - 1 && c == M - 1) {
                return maze[r][c];
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dRow[d];
                int nc = c + dCol[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc] || maze[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                maze[nr][nc] = maze[r][c] + 1;
                queue.offer(new int[] { nr, nc });
            }
        }

        return -1;
    }
}
