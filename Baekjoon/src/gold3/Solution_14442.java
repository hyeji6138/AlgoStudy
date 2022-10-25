package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14442 {
	static int N, M, K;
	static int[][] map;
	static int[][][] visit; // 어떤 좌표 i,j에 벽을 부순 횟수(k)별로 거리 기록

	static int[] di = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dj = { 1, 0, -1, 0 }; // 우하좌상

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new int[N][M][K+1];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k <= K; k++) {
					visit[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(0, 0, 0));
		for (int k = 0; k <= K; k++) {
			visit[0][0][k] = 1;
		}

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < di.length; d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];

				if (check(ni, nj) && map[ni][nj] == 0 && visit[ni][nj][now.wall] > visit[now.i][now.j][now.wall] + 1) {
					// 범위 안에 있고 벽이 아니면서 최소거리이면 갱신
					visit[ni][nj][now.wall] = visit[now.i][now.j][now.wall] + 1;
					queue.add(new Point(ni, nj, now.wall));
				} else if (check(ni, nj) && map[ni][nj] == 1 && now.wall < K && visit[ni][nj][now.wall+1] > visit[now.i][now.j][now.wall] + 1) {
					// 범위 안에 있고 벽이지만 뚫을 수 있고 최소거리이면 갱신
					visit[ni][nj][now.wall+1] = visit[now.i][now.j][now.wall] + 1;
					queue.add(new Point(ni, nj, now.wall+1));
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int k = 0; k <= K; k++) {
			ans = Math.min(ans, visit[N - 1][M - 1][k]);
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	static boolean check(int i, int j) {
		if (i >= 0 && i < N && j >= 0 && j < M)
			return true;
		return false;
	}

	static class Point {
		int i, j, wall; // 벽을 부순 횟수 0,1

		Point(int i, int j, int wall) {
			this.i = i;
			this.j = j;
			this.wall = wall;
		}
	}
}
