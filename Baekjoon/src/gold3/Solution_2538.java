package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2538 {
	static int N, M;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// =========================================
		int cheese = countCheese();
		int time = 0;
		while (cheese > 0) {
			time++;
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visit = new boolean[N][M];
			int[][] count = new int[N][M];
			queue.add(new int[] { 0, 0 });
			visit[0][0] = true;

			while (!queue.isEmpty()) {
				int[] point = queue.poll();

				for (int d = 0; d < di.length; d++) {
					int ni = point[0] + di[d];
					int nj = point[1] + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
						if (map[ni][nj] == 0 && !visit[ni][nj]) {
							visit[ni][nj] = true;
							queue.add(new int[] { ni, nj });
						} else if (map[ni][nj] == 1) {
							count[ni][nj]++;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (count[i][j] >= 2) {
						map[i][j] = 0;
					}
				}
			}
			cheese = countCheese();
		}
		System.out.println(time);

	}

	public static int countCheese() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}

}
