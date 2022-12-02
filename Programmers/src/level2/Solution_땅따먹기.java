package level2;

import java.util.Arrays;

public class Solution_땅따먹기 {
	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println(solution(land));
	}

	public static int solution(int[][] land) {
		int answer = 0;
		int[][] max = new int[land.length][4];
		for (int j = 0; j < 4; j++) {
			max[0][j] = land[0][j];
		}
		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < 4; j++) {
				for (int nj = 0; nj < 4; nj++) {
					if (j != nj) {
						max[i][j] = Math.max(max[i][j], max[i - 1][nj] + land[i][j]);
						answer = Math.max(answer, max[i][j]);
					}
				}
			}
		}
//		System.out.println(Arrays.toString(max[land.length - 1]));
		return answer;
	}

}
