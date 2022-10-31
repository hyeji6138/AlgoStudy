package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14890 {
	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ===============================================================
		int count = 0;
		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < N; i++) { // 가로
			boolean isPos = true;
			for (int j = 1; j < N; j++) {
				if (Math.abs(map[i][j - 1] - map[i][j]) > 1) { // 차이가 1이상일 때 이동 x
					isPos = false;
					break;
				} else if (Math.abs(map[i][j - 1] - map[i][j]) == 1) { // 차이가 1일 때
					if (!check(i, j, 0, visit)) {
						isPos = false;
						break;
					}
				}
			}
			if (isPos) {
				count++;
			}
		}

		visit = new boolean[N][N];
		for (int j = 0; j < N; j++) { // 세로
			boolean isPos = true;
			for (int i = 1; i < N; i++) {
				if (Math.abs(map[i - 1][j] - map[i][j]) > 1) { // 차이가 1이상일 때 이동 x
					isPos = false;
					break;
				} else if (Math.abs(map[i - 1][j] - map[i][j]) == 1) { // 차이가 1일 때
					if (!check(i, j, 1, visit)) {
						isPos = false;
						break;
					}
				}
			}
			if (isPos) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static boolean check(int i, int j, int d, boolean[][] visit) { // 경사를 만들 수 있는지 없는지
		if (d == 0) { // 가로 탐색
			int cnt = 0;
			if (map[i][j - 1] > map[i][j]) { // 내리막
				int nj = j;
				while (nj < N && cnt < L && map[i][j] == map[i][nj] && !visit[i][nj]) {
					visit[i][nj] = true;
					cnt++;
					nj++;
				}

				if (cnt == L) {
					return true;
				}
			} else { // 오르막
				int nj = j - 1;
				while (nj >= 0 && cnt < L && map[i][j - 1] == map[i][nj] && !visit[i][nj]) {
					visit[i][nj] = true;
					cnt++;
					nj--;
				}

				if (cnt == L) {
					return true;
				}
			}
		} else {
			int cnt = 0;
			if (map[i - 1][j] > map[i][j]) { // 내리막
				int ni = i;
				while (ni < N && cnt < L && map[i][j] == map[ni][j] && !visit[ni][j]) {
					visit[ni][j] = true;
					cnt++;
					ni++;
				}

				if (cnt == L) {
					return true;
				}
			} else { // 오르막
				int ni = i - 1;
				while (ni >= 0 && cnt < L && map[i - 1][j] == map[ni][j] && !visit[ni][j]) {
					visit[ni][j] = true;
					cnt++;
					ni--;
				}

				if (cnt == L) {
					return true;
				}
			}
		}

		return false;
	}

}
