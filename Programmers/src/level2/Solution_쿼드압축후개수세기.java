package level2;

import java.util.Arrays;

public class Solution_쿼드압축후개수세기 {
	static int[] answer;

	public static void main(String[] args) {
//		int[][] arr = {{1,0},{1,1}};
		int[][] arr = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[][] arr) {
		answer = new int[2];
		div(0, 0, arr.length, arr);
		return answer;
	}

	public static void div(int si, int sj, int size, int[][] arr) {
		if (size < 1) return;
		for (int i = si; i < si + size; i++) {
			for (int j = sj; j < sj + size; j++) {
				if (arr[i][j] != arr[si][sj]) {
					div(si, sj, size / 2, arr);
					div(si + size / 2, sj, size / 2, arr);
					div(si, sj + size / 2, size / 2, arr);
					div(si + size / 2, sj + size / 2, size / 2, arr);
					return;
				}
			}
		}
		answer[arr[si][sj]]++;
	}

}
