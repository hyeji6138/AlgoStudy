package level0;

public class Solution_정사각형으로만들기 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };
		printArray(solution(arr));
	}

	public static int[][] solution(int[][] arr) {
		int len = Math.max(arr.length, arr[0].length);
		int[][] answer = new int[len][len];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				answer[i][j] = arr[i][j];
			}
		}
		return answer;
	}

	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
