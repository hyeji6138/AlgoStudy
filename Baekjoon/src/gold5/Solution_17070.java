package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17070 {
	static int N, answer;
	static int[] di = { 0, 1, 1 }, dj = { 1, 1, 0 }; // 가로 대각선 세로
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// =====================================================
		answer = 0;
		go(0, 1, 0);
		System.out.println(answer);
	}

	public static void go(int i, int j, int d) {
		if (d == 1 && (map[i - 1][j] == 1 || map[i][j - 1] == 1)) {
			return;
		}
		
		if (i == N - 1 && j == N - 1) {
			answer++;
			return;
		}

		if (d == 0) { // 가로
			for (int nd = 0; nd < 2; nd++) {
				int ni = i + di[nd];
				int nj = j + dj[nd];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 0) {
					go(ni, nj, nd);
				}
			}
		} else if (d == 1) { // 대각선
			for (int nd = 0; nd < 3; nd++) {
				int ni = i + di[nd];
				int nj = j + dj[nd];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 0) {
					go(ni, nj, nd);
				}
			}
		} else { // 세로
			for (int nd = 1; nd < 3; nd++) {
				int ni = i + di[nd];
				int nj = j + dj[nd];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 0) {
					go(ni, nj, nd);
				}
			}
		}
	}

}
