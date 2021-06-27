package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15684 { // 사다리 조작
	static int N, M, H, answer;
	static int[][] map, select;
	static boolean suc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1; // 오른쪽으로 연결
			map[a][b + 1] = -1; // 왼쪽으로 연결
		}
		// ==================입력 끝========================
		suc = false;
		for (int i = 0; i <= 3; i++) {
			comb(0, 1, 1, i);
			if (suc == true) {
				answer = i;
				break;
			}
		}
		if (!suc) System.out.println(-1);
		else System.out.println(answer);
	}

	public static void comb(int cnt, int iCur, int jCur, int n) {
		if (cnt == n) {
			if (go()) suc = true;
			return;
		}

		for (int i = iCur; i <= H; i++) {
			for (int j = (i > iCur ? 0 : jCur); j < N; j++) {
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = -1;
					comb(cnt + 1, i, j + 1, n);
					map[i][j] = 0;
					map[i][j + 1] = 0;
				}
				if (suc) break;
			}
			if (suc) break;
		}
	}

	public static boolean go() {
		for (int j = 1; j <= N; j++) {
			int line = j;
			for (int i = 1; i <= H; i++) {
				if (map[i][line] != 0) {
					if (map[i][line] > 0) line += 1; // 오른쪽으로 이동
					else line -= 1; // 왼쪽으로 이동
				}
			}
			if (line != j) return false;
		}
		return true;
	}

}
