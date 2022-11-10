package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14923 {
	static int N, M;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		int Hx, Hy, Ex, Ey;
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken());
		Hy = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken());
		Ey = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ==========================================================
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visit = new boolean[N + 1][M + 1][2];
		queue.add(new Point(Hx, Hy, 0, 0)); // i, j, count, wall
		visit[Hx][Hy][0] = true;
		int answer = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.i == Ex && p.j == Ey) {
				answer = p.cnt;
				break;
			}

			for (int d = 0; d < di.length; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 1 && ni <= N && nj >= 1 && nj <= M) {
					if (map[ni][nj] == 0 && !visit[ni][nj][p.wall]) {
						queue.add(new Point(ni, nj, p.cnt + 1, p.wall));
						visit[ni][nj][p.wall] = true;
					} else if (map[ni][nj] == 1 && p.wall < 1 && !visit[ni][nj][p.wall + 1]) {
						queue.add(new Point(ni, nj, p.cnt + 1, p.wall + 1));
						visit[ni][nj][p.wall + 1] = true;
					}
				}
			}
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);

	}

	static class Point {
		int i, j, cnt, wall;

		Point(int i, int j, int cnt, int wall) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.wall = wall;
		}
	}

}
