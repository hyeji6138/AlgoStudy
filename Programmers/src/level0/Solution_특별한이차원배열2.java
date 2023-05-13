package level0;

public class Solution_특별한이차원배열2 {
	public static void main(String[] args) {
		int[][] arr = { { 5, 192, 33 }, { 192, 72, 95 }, { 33, 95, 999 } };
		System.out.println(solution(arr));
	}

	public static int solution(int[][] arr) {
		int answer = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != arr[j][i]) {
					answer = 0;
					break;
				}
			}
			if (answer == 0) {
				break;
			}
		}
		return answer;
	}

}
