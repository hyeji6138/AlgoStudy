package level2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_테이블해시함수 {
	public static void main(String[] args) {
		int[][] data = { { 2, 2, 6 }, { 1, 5, 10 }, { 4, 2, 9 }, { 3, 8, 3 } };
		int col = 2, row_begin = 2, row_end = 3;
		System.out.println(solution(data, col, row_begin, row_end));

	}

	public static int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;
		Arrays.sort(data, new MyComparator(col - 1));
		for (int i = row_begin - 1; i < row_end; i++) {
			int S_i = 0;
			for (int j = 0; j < data[i].length; j++) {
				S_i += (data[i][j] % (i + 1));
			}
			answer = answer ^ S_i;
		}
		return answer;
	}

	static class MyComparator implements Comparator<int[]> {
		int col;

		public MyComparator(int col) {
			this.col = col;
		}

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[this.col] == o2[this.col]) {
				return o2[0] - o1[0];
			}
			return o1[this.col] - o2[this.col];
		}

	}

}
