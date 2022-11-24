package level2;

public class Solution_행렬의곱셈 {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 3, 3 }, { 3, 3 } };
		int[][] answer = solution(arr1, arr2);
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				int sum = 0;
				for (int k = 0; k < arr2.length; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
				answer[i][j] = sum;
			}
		}
		return answer;
	}

}
