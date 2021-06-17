package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15683 { // 감시
	static int N, M, answer, cctvCnt;
	static int[][] map;
	static int[] array, di = { 0, -1, 0, 1 }, dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5) cctvCnt++;
			}
		}
		array = new int[cctvCnt];
		// ====================입력 끝==============================
		perm(0);
		System.out.println(answer);
	}

	public static void perm(int cnt) {
		if (cnt == cctvCnt) { // CCTV 방향
			int[][] newMap = copyMap(map);
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (1 <= map[i][j] && map[i][j] <= 5) {
						go(newMap, array[idx], i, j);
						idx++;
					}
				}
			}
			answer = Math.min(answer, countArea(newMap));
			return;
		}

		for (int i = 0; i < 4; i++) {
			array[cnt] = i;
			perm(cnt + 1);
		}
	}

	public static int countArea(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	public static void go(int[][] map, int d, int i, int j) {
		if (map[i][j] == 1) {
			int[][] dir = { { 0 }, { 1 }, { 2 }, { 3 } };
			drawing(map, d, i, j, dir);
		} else if (map[i][j] == 2) {
			int[][] dir = { { 0, 2 }, { 1, 3 }, { 2, 0 }, { 3, 1 } };
			drawing(map, d, i, j, dir);
		} else if (map[i][j] == 3) {
			int[][] dir = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
			drawing(map, d, i, j, dir);
		} else if (map[i][j] == 4) {
			int[][] dir = { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } };
			drawing(map, d, i, j, dir);
		} else {
			int[][] dir = { { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 } };
			drawing(map, d, i, j, dir);
		}
	}

	public static void drawing(int[][] map, int d, int i, int j, int[][] dir) {
		for (int dd = 0; dd < dir[d].length; dd++) {
			int ni = i;
			int nj = j;

			while (true) {
				ni += di[dir[d][dd]];
				nj += dj[dir[d][dd]];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] == 6) break;
				if (map[ni][nj] == 0) map[ni][nj] = -1;
			}
		}
	}

}
