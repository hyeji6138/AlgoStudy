package level0;

public class Solution_2차원으로만들기 {
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = 2;
		printArray(solution(num_list, n));
	}

	public static int[][] solution(int[] num_list, int n) {
		int[][] answer = new int[num_list.length / n][n];
		for (int i = 0; i < num_list.length; i++) {
			answer[i / n][i % n] = num_list[i];
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
