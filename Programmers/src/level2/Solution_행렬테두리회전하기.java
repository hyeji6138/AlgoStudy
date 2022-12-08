package level2;

import java.util.Arrays;

public class Solution_행렬테두리회전하기 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		int rows = 6, columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] square = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				square[i][j] = columns * (i - 1) + j;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotateSquare(queries[i][0], queries[i][1], queries[i][2], queries[i][3], square);
		}

		return answer;
	}

	public static int rotateSquare(int x1, int y1, int x2, int y2, int[][] square) {
		int min = Integer.MAX_VALUE;
		int i = x1, j = y1, d = 0;
		int input = square[i][j];
		while (true) {
			min = Math.min(min, input);
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < x1 || ni > x2 || nj < y1 || nj > y2) {
				d = (d + 1) % 4;
				ni = i + di[d];
				nj = j + dj[d];
			}
			int temp = square[ni][nj];
			square[ni][nj] = input;
			input = temp;
			if (ni == x1 && nj == y1) {
				break;
			} else {
				i = ni;
				j = nj;
			}
		}
		return min;
	}

}
