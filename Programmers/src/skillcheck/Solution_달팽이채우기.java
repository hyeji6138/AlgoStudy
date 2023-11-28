package skillcheck;

import java.util.Arrays;

public class Solution_달팽이채우기 {
	static int[] di = { 1, 0, -1 }, dj = { 0, 1, -1 };

	public static void main(String[] args) {
		int n = 6;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		int size = 0;
		for (int i = 1; i <= n; i++) {
			size += i;
		}
		int[] answer = new int[size];
		int[][] triangle = new int[n][n];
		for (int num = 1, i = 0, j = 0, d = 0; num <= size; num++) {
			triangle[i][j] = num;
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < 0 || ni >= n || nj < 0 || nj >= n || triangle[ni][nj] != 0) {
				d = (d + 1) % 3;
			}
			i = i + di[d];
			j = j + dj[d];
		}
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				answer[idx++] = triangle[i][j];
			}
		}
		return answer;
	}

}
