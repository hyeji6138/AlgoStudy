package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2636 {
	static int N, M, cheese;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese++;
				}
			}
		}
		// ====================================================
		int time = 0;
		int remove = 0;
		while (true) {
			remove = 0;
			boolean[][] visit = new boolean[N][M];
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { 0, 0 });
			visit[0][0] = true;

			while (!queue.isEmpty()) {
				int[] point = queue.poll();

				for (int d = 0; d < di.length; d++) {
					int ni = point[0] + di[d];
					int nj = point[1] + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visit[ni][nj]) {
						visit[ni][nj] = true;
						if (map[ni][nj] == 0) {
							queue.add(new int[] { ni, nj });
						} else {
							map[ni][nj] = 0;
							remove++;
						}
					}
				}
			}
			time++;
			if (cheese - remove == 0) break;
			cheese -= remove;
		}
		if(remove == 0) { // 치즈 안 없애도 시간 카운팅이 들어가서 예외처리(60번째 줄)
			time = 0;
		}
		System.out.println(time + "\n" + remove);

	}

}
