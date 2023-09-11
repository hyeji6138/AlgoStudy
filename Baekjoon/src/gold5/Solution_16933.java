package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16933 {
	static int N, M, K, answer;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = -1;

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		Queue<Point> queue = new LinkedList<>();
		int[][] visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		queue.add(new Point(0, 0, 0, 0, true));
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			if (p.i == N - 1 && p.j == M - 1) {
				answer = p.cnt + 1;
				break;
			}

			for (int d = 0; d < di.length; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				 
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && visit[ni][nj] > p.wall) {
					if (p.day) { // 낮
						if (map[ni][nj] == 1 && p.wall < K) {
							queue.add(new Point(ni, nj, p.cnt + 1, p.wall + 1, !p.day));
							visit[ni][nj] = p.wall + 1;
						} else if (map[ni][nj] == 0) {
							queue.add(new Point(ni, nj, p.cnt + 1, p.wall, !p.day));
							visit[ni][nj] = p.wall;
						}
					} else { // 밤
						if (map[ni][nj] == 0) {
							queue.add(new Point(ni, nj, p.cnt + 1, p.wall, !p.day));
							visit[ni][nj] = p.wall;
						} else {
							queue.add(new Point(p.i, p.j, p.cnt + 1, p.wall, !p.day));
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	static class Point {
		int i, j;
		int cnt, wall;
		boolean day;

		Point(int i, int j, int cnt, int wall, boolean day) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.wall = wall;
			this.day = day;
		}
	}
}