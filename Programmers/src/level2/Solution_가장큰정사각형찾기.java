package level2;

public class Solution_가장큰정사각형찾기 {
	static int[] di = { -1, -1, 0 }, dj = { 0, -1, -1 };

	public static void main(String[] args) {
		int[][] board = { { 1 } };
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int answer = 0;
		int n = board.length, m = board[0].length;
		int[][] size = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					boolean sqr = true;
					for (int d = 0; d < di.length; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
							if (min > size[ni][nj]) {
								min = size[ni][nj];
							}
						} else {
							sqr = false;
							break;
						}
					}
					if (sqr) {
						size[i][j] = min + 1;
					} else {
						size[i][j] = board[i][j];
					}
					max = Math.max(max, size[i][j]);
				}
				System.out.print(size[i][j] + " ");
			}
			System.out.println();
		}

		answer = max * max;
		return answer;
	}

}
