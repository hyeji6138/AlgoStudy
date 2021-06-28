package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2573 { // 빙산
	static int N, M;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) q.add(i * M + j);
			}
		}
		// ===============입력 끝====================
		int answer = 0;
		boolean suc = false;
		while (!q.isEmpty()) {
			suc = check();
			if (suc) break;
			answer++;
			int[][] newMap = new int[N][M];
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int now = q.poll();
				int i = now / M;
				int j = now % M;
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) cnt++;
				}

				newMap[i][j] = map[i][j] - cnt <= 0 ? 0 : map[i][j] - cnt;
				if (newMap[i][j] != 0) q.add(i * M + j);
			}
			map = newMap;
		}
		if(!suc) System.out.println(0);
		else System.out.println(answer);

	}

	public static boolean check() {
		boolean[][] visit = new boolean[N][M];
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 || visit[i][j]) continue;
				cnt++;
				visit[i][j] = true;
				q.add(i * M + j);

				while (!q.isEmpty()) {
					int n = q.poll();
					for (int d = 0; d < 4; d++) {
						int ni = n / M + di[d];
						int nj = n % M + dj[d];

						if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visit[ni][nj] && map[ni][nj] != 0) {
							visit[ni][nj] = true;
							q.add(ni * M + nj);
						}
					}
				}
			}
		}
		if(cnt >= 2) return true;
		return false;
	}

}
