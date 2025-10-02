import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] distance;
	static int N;
	static int M;
	static int[][] maze;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		maze = new int[N][M];
		distance = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		bw.write(String.valueOf(distance[N - 1][M - 1]));
		bw.close();
	}

	public static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y });
		distance[x][y] = 1;

		while (!queue.isEmpty()) {
			int current_x = queue.getFirst()[0];
			int current_y = queue.getFirst()[1];
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int next_x = current_x + dx[i];
				int next_y = current_y + dy[i];

				if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) {
					continue;
				}

				if (maze[next_x][next_y] == 0 || distance[next_x][next_y] != 0) {
					continue;
				}

				queue.add(new int[] { next_x, next_y });
				distance[next_x][next_y] = distance[current_x][current_y] + 1;
			}
		}
	}
}
