package level2;

import java.util.Arrays;

public class Solution_삼각달팽이 {
	static int[] di = { 1, 0, -1 }, dj = { 0, 1, -1 };

	public static void main(String[] args) {
		int n = 1000;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		int len = triangleLength(n);
		int[] answer = new int[len];
		int[][] square = new int[n][n];
		for (int num = 1, d = 0, i = 0, j = 0; num <= len; num++) {
			square[i][j] = num;
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < 0 || ni >= n || nj < 0 || nj >= n || square[ni][nj] != 0) {
				d = (d + 1) % 3;
			}
			i += di[d];
			j += dj[d];
		}
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (square[i][j] != 0) {
					answer[idx++] = square[i][j];
				}
			}
		}
		return answer;
	}

	public static int triangleLength(int n) {
		int len = 0;
		for (int i = 1; i <= n; i++) {
			len += i;
		}
		return len;
	}

}
