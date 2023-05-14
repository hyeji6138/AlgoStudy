package level0;

public class Solution_특별한이차원배열1 {
	public static void main(String[] args) {
		int n = 6;
		printArray(solution(n));
	}

	public static int[][] solution(int n) {
		int[][] answer = new int[n][n];
		for (int i = 0; i < n; i++) {
			answer[i][i] = 1;
		}
		return answer;
	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}
