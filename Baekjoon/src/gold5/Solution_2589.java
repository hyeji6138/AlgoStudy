package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2589 { // 보물섬
	static int R, C, answer;
	static char[][] map;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// ===============입력끝================
		boolean[][] visit;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'W') continue;

				visit = new boolean[R][C];
				q.clear();

				q.add(i * C + j);
				visit[i][j] = true;
				int dist = 0;
				while (!q.isEmpty()) {
					int size = q.size();
					for (int s = 0; s < size; s++) {
						int now = q.poll();

						for (int d = 0; d < 4; d++) {
							int ni = now / C + di[d];
							int nj = now % C + dj[d];

							if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visit[ni][nj] && map[ni][nj] == 'L') {
								visit[ni][nj] = true;
								q.add(ni * C + nj);
							}
						}
					}
					dist++;
				}
				answer = Math.max(answer, dist);
			}
		}
		System.out.println(answer - 1);
	}

}
