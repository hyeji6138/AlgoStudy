package level3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visit = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				answer++;
				queue.add(i);
				visit[i] = true;
				while (!queue.isEmpty()) {
					int c = queue.poll();
					for (int ni = 0; ni < n; ni++) {
						if (!visit[ni] && computers[c][ni] == 1) {
							queue.add(ni);
							visit[ni] = true;
						}
					}
				}
			}
		}
		return answer;
	}

}
