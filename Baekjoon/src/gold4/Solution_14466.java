package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14466 {
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 목초지 크기
		int K = Integer.parseInt(st.nextToken()); // 소 마릿수
		int R = Integer.parseInt(st.nextToken()); // 다리 개수
		boolean[][][][] bridge = new boolean[N][N][N][N];
		int[][] cow = new int[K][2];
		int answer = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;

			bridge[r1][c1][r2][c2] = true;
			bridge[r2][c2][r1][c1] = true;
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cow[i][0] = Integer.parseInt(st.nextToken()) - 1;
			cow[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 0; i < K; i++) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visit = new boolean[N][N];
			q.add(new int[] { cow[i][0], cow[i][1] });
			visit[cow[i][0]][cow[i][1]] = true;

			while (!q.isEmpty()) {
				int[] p = q.poll();

				for (int d = 0; d < di.length; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visit[ni][nj] && !bridge[p[0]][p[1]][ni][nj]) {
						q.add(new int[] { ni, nj });
						visit[ni][nj] = true;
					}
				}
			}

			for (int j = i + 1; j < K; j++) {
				if (!visit[cow[j][0]][cow[j][1]]) {
					answer += 1;
				}
			}
		}

		System.out.println(answer);
	}

}
