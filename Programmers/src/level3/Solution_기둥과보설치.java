package level3;

import java.util.Arrays;

public class Solution_기둥과보설치 {
	static int[][][] map;

	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		printArray(solution(n, build_frame));
	}

	static public int[][] solution(int n, int[][] build_frame) {
		map = new int[n + 1][n + 1][2];
		int cnt = 0;
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];

			if (b == 1) { // 설치
				if (isPossible(n, x, y, a)) {
					map[x][y][a] = 1;
					cnt += 1;
				}
			} else { // 삭제
				map[x][y][a] = 0;
				boolean isPos = true;
				if (a == 0) { // 기둥 삭제
					if (y < n && map[x][y + 1][0] == 1 && !isPossible(n, x, y + 1, 0)) {
						isPos = false;
					} else if (y < n - 1 && map[x][y + 1][1] == 1 && !isPossible(n, x, y + 1, 1)) {
						isPos = false;
					} else if (x > 0 && y < n - 1 && map[x - 1][y + 1][1] == 1 && !isPossible(n, x - 1, y + 1, 1)) {
						isPos = false;
					}
				} else { // 보 삭제
					if (map[x][y][0] == 1 && !isPossible(n, x, y, 0)) {
						isPos = false;
					} else if (x < n && map[x + 1][y][0] == 1 && !isPossible(n, x + 1, y, 0)) {
						isPos = false;
					} else if (x > 0 && map[x - 1][y][1] == 1 && !isPossible(n, x - 1, y, 1)) {
						isPos = false;
					} else if (x < n - 1 && map[x + 1][y][1] == 1 && !isPossible(n, x + 1, y, 1)) {
						isPos = false;
					}
				}
				if (!isPos) {
					map[x][y][a] = 1;
				} else {
					cnt -= 1;
				}
			}
		}
		int[][] answer = new int[cnt][3];
		cnt = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int a = 0; a < 2; a++) {
					if (map[i][j][a] == 1) {
						answer[cnt][0] = i;
						answer[cnt][1] = j;
						answer[cnt][2] = a;
						cnt += 1;
					}
				}
			}
		}
		return answer;
	}

	static public boolean isPossible(int n, int x, int y, int a) {
		boolean result = false;
		if (a == 0) { // 기둥 설치
			if (y == 0) {
				result = true;
			} else if (y > 0 && map[x][y - 1][0] == 1) {
				result = true;
			} else if (x > 0 && map[x - 1][y][1] == 1) {
				result = true;
			} else if (x < n && map[x][y][1] == 1) {
				result = true;
			}
		} else { // 보 설치
			if (y > 0 && map[x][y - 1][0] == 1) {
				result = true;
			} else if (y > 0 && map[x + 1][y - 1][0] == 1) {
				result = true;
			} else if (x > 0 && x < n - 1 && map[x - 1][y][1] == 1 && map[x + 1][y][1] == 1) {
				result = true;
			}
		}
		return result;
	}

	static public void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
}
