package level3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_순위 {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = { { 4, 3 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(solution(n, results));
	}

	static public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] win = new int[n][n];
		int[][] lose = new int[n][n];
		for (int i = 0; i < results.length; i++) {
			win[results[i][0] - 1][results[i][1] - 1] = 1;
			lose[results[i][1] - 1][results[i][0] - 1] = 1;
		}
		for (int i = 0; i < n; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visit = new boolean[n];
			queue.add(i); // 번호, 카운트
			visit[i] = true;
			int cnt = 0;
			while (!queue.isEmpty()) {
				int now = queue.poll();
				for (int j = 0; j < n; j++) {
					if (now != j && !visit[j]) {
						if (win[now][j] > 0) {
							queue.add(j);
							visit[j] = true;
							cnt += 1;
						}
					}
				}
			}
			queue.add(i);
			while (!queue.isEmpty()) {
				int now = queue.poll();
				for (int j = 0; j < n; j++) {
					if (now != j && !visit[j]) {
						if (lose[now][j] > 0) {
							queue.add(j);
							visit[j] = true;
							cnt += 1;
						}
					}
				}
			}
			if (cnt == n - 1) {
				answer += 1;
			}

		}
		return answer;
	}

}
