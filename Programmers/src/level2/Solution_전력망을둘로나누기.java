package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_전력망을둘로나누기 {
	public static void main(String[] args) {
		int n = 9;
		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		System.out.println(solution(n, wires));
	}

	public static int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		boolean[][] link = new boolean[n + 1][n + 1];
		for (int i = 0; i < wires.length; i++) {
			link[wires[i][0]][wires[i][1]] = true;
			link[wires[i][1]][wires[i][0]] = true;
		}

		for (int i = 0; i < wires.length; i++) {
			link[wires[i][0]][wires[i][1]] = false;
			link[wires[i][1]][wires[i][0]] = false;
			answer = Math.min(answer, go(n, link));
			link[wires[i][0]][wires[i][1]] = true;
			link[wires[i][1]][wires[i][0]] = true;
		}

		return answer;
	}

	public static int go(int n, boolean[][] link) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] top = new boolean[n + 1];
		queue.add(1);
		top[1] = true;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int i = 1; i <= n; i++) {
				if (!top[i] && link[num][i]) {
					top[i] = true;
					queue.add(i);
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (top[i]) {
				cnt++;
			}
		}
		return Math.abs(cnt - (n - cnt));
	}

}
