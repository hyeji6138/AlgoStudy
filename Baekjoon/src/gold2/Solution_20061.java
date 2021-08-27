package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_20061 {
	static int N, answer;
	static int[][] block, map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		block = new int[N][3];
		map = new int[10][10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ======================입력 끝=========================
		for (int i = 0; i < N; i++) {
			// 오른쪽 이동
			int my = right(block[i], map);
			int mx = down(block[i], map);
			while (true) {
				int greenScore = boomGreen(map, mx, block[i][0]);
				if (greenScore <= 0) break;
				answer += greenScore;
			}
			while (true) {
				int blueScore = boomBlue(map, my, block[i][0]);
				if (blueScore <= 0) break;
				answer += blueScore;
			}
			int down = 0, right = 0;
			for (int x = 4; x <= 5; x++) {
				for (int y = 0; y < 4; y++) {
					if (map[x][y] == 1) {
						down++;
						break;
					}
				}
			}
			for (int y = 4; y <= 5; y++) {
				for (int x = 0; x < 4; x++) {
					if (map[x][y] == 1) {
						right++;
						break;
					}
				}
			}
			for (int x = 9 - down; x >= 0; x--) {
				for (int y = 0; y < 4; y++) {
					map[x + down][y] = map[x][y];
				}
			}
			for (int y = 9 - right; y >= 0; y--) {
				for (int x = 0; x < 4; x++) {
					map[x][y + right] = map[x][y];
				}
			}
		}
		System.out.println(answer + "\n" + cntBlock(map));
	}

	public static int cntBlock(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[6 + i][j] == 1) cnt++;
				if (map[i][6 + j] == 1) cnt++;
			}
		}
		return cnt;
	}

	public static int boomGreen(int[][] map, int mx, int type) {
		int result = 0;
		switch (type) {
		case 1: // 한칸 블럭
			for (int y = 0; y < 4; y++) {
				if (map[mx][y] != 1) return 0;
			}
			result = 1;
			for (int x = mx - 1; x >= 0; x--) {
				for (int y = 0; y < 4; y++) {
					map[x + 1][y] = map[x][y];
				}
			}
			break;
		case 2: // 가로 두칸
			for (int y = 0; y < 4; y++) {
				if (map[mx][y] != 1) return 0;
			}
			result = 1;
			for (int x = mx - 1; x >= 0; x--) {
				for (int y = 0; y < 4; y++) {
					map[x + 1][y] = map[x][y];
				}
			}
			break;
		case 3: // 세로 두칸
			boolean boom = true;
			int std = 0;
			for (int y = 0; y < 4; y++) {
				if (map[mx][y] != 1) {
					boom = false;
					break;
				}
			}
			if (boom) {
				result++;
				std = mx;
			}
			boom = true;
			for (int y = 0; y < 4; y++) {
				if (map[mx - 1][y] != 1) {
					boom = false;
					break;
				}
			}
			if (boom) {
				result++;
				std = mx - 1;
			}
			for (int x = std - 1; x >= 0; x--) {
				for (int y = 0; y < 4; y++) {
					map[x + result][y] = map[x][y];
				}
			}
			break;
		}
		return result;
	}

	public static int boomBlue(int[][] map, int my, int type) {
		int result = 0;
		switch (type) {
		case 1: // 한칸 블럭
			for (int x = 0; x < 4; x++) {
				if (map[x][my] != 1) return 0;
			}
			result = 1;
			for (int y = my - 1; y >= 0; y--) {
				for (int x = 0; x < 4; x++) {
					map[x][y + 1] = map[x][y];
				}
			}
			break;
		case 2: // 가로 두칸
			boolean boom = true;
			int std = 0;
			for (int x = 0; x < 4; x++) {
				if (map[x][my] != 1) {
					boom = false;
					break;
				}
			}
			if (boom) {
				result++;
				std = my;
			}
			boom = true;
			for (int x = 0; x < 4; x++) {
				if (map[x][my - 1] != 1) {
					boom = false;
					break;
				}
			}
			if (boom) {
				result++;
				std = my - 1;
			}
			for (int y = std - 1; y >= 0; y--) {
				for (int x = 0; x < 4; x++) {
					map[x][y + result] = map[x][y];
				}
			}
			break;
		case 3: // 세로 두칸
			for (int x = 0; x < 4; x++) {
				if (map[x][my] != 1) return 0;
			}
			result = 1;
			for (int y = my - 1; y >= 0; y--) {
				for (int x = 0; x < 4; x++) {
					map[x][y + 1] = map[x][y];
				}
			}
			break;
		}
		return result;
	}

	public static int right(int[] block, int[][] map) {
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		switch (block[0]) {
		case 1: // 한칸 블럭
			x1 = block[1];
			y2 = block[2];

			while (y2 < 10 && map[x1][y2] == 0) {
				y2++;
			}
			map[x1][y2 - 1] = 1;
			break;
		case 2: // 가로 두칸 블럭
			x1 = block[1];
			y1 = block[2];
			y2 = block[2] + 1;

			while (y2 < 10 && map[x1][y2] == 0) {
				y1++;
				y2++;
			}
			map[x1][y1 - 1] = map[x1][y2 - 1] = 1;
			break;
		case 3: // 세로 두칸 블럭
			x1 = block[1];
			x2 = block[1] + 1;
			y2 = block[2];

			while (y2 < 10 && map[x1][y2] == 0 && map[x2][y2] == 0) {
				y2++;
			}
			map[x1][y2 - 1] = map[x2][y2 - 1] = 1;
			break;
		}
		return y2 - 1; // y축 번호 리턴
	}

	public static int down(int[] block, int[][] map) {
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		switch (block[0]) {
		case 1: // 한칸 블럭
			x2 = block[1];
			y1 = block[2];

			while (x2 < 10 && map[x2][y1] == 0) {
				x2++;
			}
			map[x2 - 1][y1] = 1;
			break;
		case 2: // 가로 두칸 블럭
			x2 = block[1];
			y1 = block[2];
			y2 = block[2] + 1;

			while (x2 < 10 && map[x2][y1] == 0 && map[x2][y2] == 0) {
				x2++;
			}
			map[x2 - 1][y1] = map[x2 - 1][y2] = 1;
			break;
		case 3: // 세로 두칸 블럭
			x1 = block[1];
			x2 = block[1] + 1;
			y1 = block[2];

			while (x2 < 10 && map[x2][y1] == 0) {
				x1++;
				x2++;
			}
			map[x1 - 1][y1] = map[x2 - 1][y1] = 1;
			break;
		}
		return x2 - 1; // y축 번호 리턴
	}

}
