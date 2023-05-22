package level0;

public class Solution_정수를나선형으로배치하기 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		int n = 4;
		printArray(solution(n));
	}

	public static int[][] solution(int n) {
		int[][] answer = new int[n][n];
		int num = 0, d = 0, i = 0, j = 0;
		while (num < n * n) {
			answer[i][j] = ++num;
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < 0 || ni >= n || nj < 0 || nj >= n || answer[ni][nj] != 0) {
				d = (d + 1) % 4;
			}
			i += di[d];
			j += dj[d];
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
