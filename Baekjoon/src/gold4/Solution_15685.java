package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15685 {
	static int N;
	static boolean[][] map;
	static int[] di = { 0, -1, 0, 1 }, dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon(y, x, d, g);
		}
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j + 1] && map[i + 1][j]) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static void dragon(int x, int y, int d, int g) {
		int[] curv = new int[(int) Math.pow(2, 10)];
		curv[0] = d;
		for (int t = 0; t < g; t++) {
			for (int s = 0; s < (int) Math.pow(2, t); s++) {
				curv[(int) Math.pow(2, t + 1) - (s + 1)] = (curv[s] + 1) % 4;
			}
		}
		int[] std = { x, y };
		map[std[0]][std[1]] = true;
		for (int i = 0; i < (int) Math.pow(2, g); i++) {
			int ni = std[0] + di[curv[i]];
			int nj = std[1] + dj[curv[i]];
			if (ni >= 0 && ni <= 100 && nj >= 0 && nj <= 100) {
				map[ni][nj] = true;
			}
			std[0] = ni;
			std[1] = nj;
		}
	}

}
