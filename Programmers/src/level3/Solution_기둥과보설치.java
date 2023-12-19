package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_기둥과보설치 {
	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		printArray(solution(n, build_frame));
	}

	static public int[][] solution(int n, int[][] build_frame) {
		int[][] map = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				map[i][j] = -1;
			}
		}
		for (int i = 0; i < build_frame.length; i++) {
			map = go(n, map, build_frame[i]);
		}
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (map[i][j] != -1) {
					list.add(new int[] { i, j, map[i][j] });
				}
			}
		}
		int[][] answer = new int[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 3; j++) {
				answer[i][j] = list.get(i)[j];
			}
		}
		return answer;
	}

	static public int[][] go(int n, int[][] map, int[] frame) {
		int[][] result = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				result[i][j] = map[i][j];
			}
		}
		if (frame[3] == 0) { // 삭제
			result[frame[0]][frame[1]] = -1;
		} else {
			result[frame[0]][frame[1]] = frame[2];
		}
		boolean check = true;
		for (int x = 0; x <= n && check; x++) {
			for (int y = 0; y <= n && check; y++) {
				if (result[x][y] == 0) {
					if (y != 0 && result[x][y - 1] != 0 && (x > 0 && result[x - 1][y] != 1)) {
						check = false;
					}
				} else if (result[x][y] == 1) {
					if (result[x][y - 1] != 0 && result[x + 1][y - 1] != 0
							&& (x > 0 && result[x - 1][y] != 1 || result[x + 1][y] != 1)) {
						check = false;
					}
				}
			}
		}
		if (check) {
			return result;
		} else {
			return map;
		}
	}

	static public void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
}
