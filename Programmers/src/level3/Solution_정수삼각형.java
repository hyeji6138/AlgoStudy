package level3;

public class Solution_정수삼각형 {
	static int[] di = { -1, -1 }, dj = { -1, 0 };

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		int[][] sum = new int[triangle.length][triangle.length];
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				sum[i][j] = triangle[i][j];
				int max = 0;
				for (int d = 0; d < di.length; d++) {
					int pi = i + di[d];
					int pj = j + dj[d];
					if (pi >= 0 && pi < triangle.length && pj >= 0 && pj < triangle.length && max < sum[pi][pj]) {
						max = sum[pi][pj];
					}
				}
				sum[i][j] = sum[i][j] + max;
			}
		}
		answer = Integer.MIN_VALUE;
		for (int i = 0; i < triangle.length; i++) {
			if (answer < sum[triangle.length - 1][i]) {
				answer = sum[triangle.length - 1][i];
			}
		}
		return answer;
	}

}
