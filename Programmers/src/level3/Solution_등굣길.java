package level3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_등굣길 {
	static int[] di = { 0, 1 }, dj = { 1, 0 };

	public static void main(String[] args) {
		int m = 4, n = 3;
		int[][] puddles = { { 2, 2 } };
		System.out.println(solution(m, n, puddles));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int[][] map = new int[n][m];
		map[0][0] = 1;
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != -1) {
					int top = 0, left = 0;
					if (i - 1 >= 0 && map[i - 1][j] != -1) {
						top = map[i - 1][j];
					}
					if (j - 1 >= 0 && map[i][j - 1] != -1) {
						left = map[i][j - 1];
					}
					map[i][j] = map[i][j] + (top + left) % 1000000007;
				}
				System.out.println(i + " " + j + " " + map[i][j]);
			}
		}

//		int answer = 0;
//		int[][] map = new int[m][n];
//		boolean[][] puddle = new boolean[m][n];
//		boolean[][] visit = new boolean[m][n];
//		for (int i = 0; i < puddles.length; i++) {
//			puddle[puddles[i][0] - 1][puddles[i][1] - 1] = true;
//		}
//		Queue<int[]> queue = new LinkedList<>();
//		queue.add(new int[] { 0, 0 });
//		visit[0][0] = true;
//		map[0][0] = 1;
//		while (!queue.isEmpty()) {
//			int[] point = queue.poll();
//
//			for (int d = 0; d < di.length; d++) {
//				int ni = point[0] + di[d];
//				int nj = point[1] + dj[d];
//
//				if (ni >= 0 && ni < m && nj >= 0 && nj < n && !puddle[ni][nj]) {
//					if (!visit[ni][nj]) {
//						visit[ni][nj] = true;
//						queue.add(new int[] { ni, nj });
//					}
//					map[ni][nj] = (map[ni][nj] + map[point[0]][point[1]]) % 1000000007;
//				}
//			}
//
//		}
//		answer = map[m - 1][n - 1];
		answer = map[n - 1][m - 1];
		return answer;
	}

}
