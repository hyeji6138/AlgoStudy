package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_10026 {
	static int N;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// ======================================
		int answer1 = 0;
		int answer2 = 0;

		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					visit[i][j] = true;

					while (!queue.isEmpty()) {
						int[] point = queue.poll();

						for (int d = 0; d < di.length; d++) {
							int ni = point[0] + di[d];
							int nj = point[1] + dj[d];

							if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visit[ni][nj] && map[ni][nj] == map[i][j]) {
								visit[ni][nj] = true;
								queue.add(new int[] { ni, nj });
							}
						}
					}
					answer1++;
				}
			}
		}

		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					visit[i][j] = true;

					while (!queue.isEmpty()) {
						int[] point = queue.poll();

						for (int d = 0; d < di.length; d++) {
							int ni = point[0] + di[d];
							int nj = point[1] + dj[d];

							if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visit[ni][nj]) {
								if (map[ni][nj] == map[i][j] || (map[ni][nj] == 'R' && map[i][j] == 'G') || (map[ni][nj] == 'G' && map[i][j] == 'R')) {
									visit[ni][nj] = true;
									queue.add(new int[] { ni, nj });
								}
							}
						}
					}
					answer2++;
				}
			}
		}
		System.out.println(answer1+" "+answer2);

	}

}
