package level0;

public class Solution_안전지대 {
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 }, dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int N = board.length, M = board[0].length;
		int answer = N * M;
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					int cnt = 0;
					if (!visit[i][j]) {
						visit[i][j] = true;
						cnt = 1;
					}
					for (int d = 0; d < di.length; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visit[ni][nj]) {
							visit[ni][nj] = true;
							cnt += 1;
						}
					}
					answer -= cnt;
				}
			}
		}
		return answer;
	}

}
