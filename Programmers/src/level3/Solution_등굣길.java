package level3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_등굣길 {
	static int[] di = { 0, 1 }, dj = { 1, 0 };

	public static void main(String[] args) {
		int m = 4, n = 3;
		int[][] puddles = { { 2, 2 } };
		System.out.println(solution(m, n, puddles));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int[][] map = new int[n][m];
		map[0][0] = 1;
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != -1) {
					int top = 0, left = 0;
					if (i - 1 >= 0 && map[i - 1][j] != -1) {
						top = map[i - 1][j];
					}
					if (j - 1 >= 0 && map[i][j - 1] != -1) {
						left = map[i][j - 1];
					}
					map[i][j] = map[i][j] + (top + left) % 1000000007;
				}
			}
		}
		answer = map[n - 1][m - 1];
		return answer;
	}

}
