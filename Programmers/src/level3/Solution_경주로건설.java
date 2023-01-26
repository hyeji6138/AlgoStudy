package level3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_경주로건설 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		int n = board.length, m = board[0].length;
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][][] cost = new int[n][m][4];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < 4; d++) {
					cost[i][j][d] = Integer.MAX_VALUE;
				}
			}
		}
		for (int d = 0; d < 4; d++) {
			cost[0][0][d] = 0;
		}
		queue.add(new int[] { 0, 0, -1, 0 }); // i, j, d, cost

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();
				for (int d = 0; d < di.length; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];
					if (ni >= 0 && ni < n && nj >= 0 && nj < m && board[ni][nj] != 1) {
						if ((p[2] == -1 || p[2] == d) && cost[ni][nj][d] >= p[3] + 100) {
							cost[ni][nj][d] = p[3] + 100;
							queue.add(new int[] { ni, nj, d, p[3] + 100 });
						} else if (p[2] != d && cost[ni][nj][d] >= p[3] + 600) {
							cost[ni][nj][d] = p[3] + 600;
							queue.add(new int[] { ni, nj, d, p[3] + 600 });
						}
					}
				}
			}
		}
		for (int d = 0; d < 4; d++) {
			answer = Math.min(answer, cost[n - 1][m - 1][d]);
		}
		return answer;
	}

}
