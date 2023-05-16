package level0;

import java.util.Arrays;

public class Solution_수열과구간쿼리4 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 4, 3 };
		int[][] queries = { { 0, 4, 1 }, { 0, 3, 2 }, { 0, 3, 3 } };
		System.out.println(Arrays.toString(solution(arr, queries)));
	}

	public static int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}
		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				if (j % queries[i][2] == 0) {
					answer[j] += 1;
				}
			}
		}
		return answer;
	}

}
