package level1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_PCCE기출10번데이터분석 {
	public static void main(String[] args) {
		int[][] data = { { 1, 20300104, 100, 80 }, { 2, 20300804, 847, 37 }, { 3, 20300401, 10, 8 } };
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";
		printArray(solution(data, ext, val_ext, sort_by));
	}

	static public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		int[][] answer = {};
		int size = 0;
		int sort_op = getExtNum(sort_by);
		int ext_op = getExtNum(ext);
		Arrays.sort(data, new MySort(sort_op));
		for (int i = 0; i < data.length; i++) {
			if (data[i][ext_op] < val_ext) {
				size += 1;
			}
		}
		answer = new int[size][4];
		size = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i][ext_op] < val_ext) {
				for (int j = 0; j < 4; j++) {
					answer[size][j] = data[i][j];
				}
				size += 1;
			}
		}
		return answer;
	}

	static public int getExtNum(String ext) {
		int num = 0;
		if (ext.equals("code")) {
			num = 0;
		} else if (ext.equals("date")) {
			num = 1;
		} else if (ext.equals("maximum")) {
			num = 2;
		} else {
			num = 3;
		}
		return num;
	}

	static class MySort implements Comparator<int[]> {
		int op;

		MySort(int op) {
			this.op = op;
		}

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub

			return o1[this.op] - o2[this.op];
		}

	}

	static public void printArray(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

}
