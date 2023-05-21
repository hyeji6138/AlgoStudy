package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_숫자변환하기2 {
	static int cnt;

	public static void main(String[] args) {
		int x = 10;
		int y = 40;
		int n = 30;
		System.out.println(solution(x, y, n));
	}

	public static int solution(int x, int y, int n) {
		int answer = -1;
		int[] visit = new int[y + 1];
		visit[x] = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				if (now <= y) {
					if (now * 3 <= y && visit[now * 3] == 0) {
						queue.add(now * 3);
						visit[now * 3] = visit[now] + 1;
					}
					if (now * 2 <= y && visit[now * 2] == 0) {
						queue.add(now * 2);
						visit[now * 2] = visit[now] + 1;
					}
					if (now + n <= y && visit[now + n] == 0) {
						queue.add(now + n);
						visit[now + n] = visit[now] + 1;
					}
				}
			}
		}
		answer = visit[y] - 1;
		return answer;
	}

}
