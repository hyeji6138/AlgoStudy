package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_가장큰정사각형찾기 {
	static int[] di = { 0, 1, 1 }, dj = { 1, 1, 0 };

	public static void main(String[] args) {
		int[][] board = { { 0, 0 }, { 0, 0 } };
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int answer = 0;
		int n = board.length, m = board[0].length;
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] > 0 && !visit[i][j]) {
					Queue<int[]> queue = new LinkedList<int[]>();
					queue.add(new int[] { i, j });
					visit[i][j] = true;
					int time = 1;
					boolean go = true;
					while (!queue.isEmpty()) {
						if (!go) {
							break;
						}
						answer = Math.max(answer, time * time);
						int size = queue.size();
						for (int s = 0; s < size && go; s++) {
							int[] p = queue.poll();

							for (int d = 0; d < di.length; d++) {
								int ni = p[0] + di[d];
								int nj = p[1] + dj[d];

								if (ni >= 0 && ni < n && nj >= 0 && nj < m && board[ni][nj] > 0) {
									if (!visit[ni][nj]) {
										queue.add(new int[] { ni, nj });
										visit[ni][nj] = true;
									}
								} else {
									go = false;
									break;
								}
							}
						}
						time++;
					}
				}
			}
		}
		return answer;
	}

}
