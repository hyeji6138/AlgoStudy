package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1926 {
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int max = 0;
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });
					visit[i][j] = true;
					int size = 0;
					while (!q.isEmpty()) {
						int[] p = q.poll();
						size += 1;

						for (int d = 0; d < di.length; d++) {
							int ni = p[0] + di[d];
							int nj = p[1] + dj[d];

							if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visit[ni][nj] && map[ni][nj] == 1) {
								q.add(new int[] { ni, nj });
								visit[ni][nj] = true;
							}
						}
					}
					cnt += 1;
					max = Math.max(max, size);
				}
			}
		}
		System.out.println(cnt + "\n" + max);
	}

}
