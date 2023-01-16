package level3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_가장먼노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(n, edge));
	}

	// 1652.83ms, 636MB
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		boolean[][] vertex = new boolean[n + 1][n + 1];
		for (int i = 0; i < edge.length; i++) {
			vertex[edge[i][0]][edge[i][1]] = true;
			vertex[edge[i][1]][edge[i][0]] = true;
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];
		visit[1] = true;
		queue.add(1);

		while (!queue.isEmpty()) {
			int size = queue.size();
			answer = size;
			for (int s = 0; s < size; s++) {
				int v = queue.poll();

				for (int next = 1; next <= n; next++) {
					if (!visit[next] && vertex[v][next]) {
						visit[next] = true;
						queue.add(next);
					}
				}
			}
		}

		return answer;
	}

}
