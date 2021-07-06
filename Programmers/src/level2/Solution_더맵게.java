package level2;

import java.util.PriorityQueue;

public class Solution_더맵게 {
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		boolean isPoss = true;
		for (int i = 0; i < scoville.length; i++) {
			q.add((long) scoville[i]);
		}
		while (q.peek() < K) {
			if (q.size() <= 1) {
				isPoss = false;
				break;
			}
			long a = q.poll();
			long b = q.poll();

			q.add(a + b * 2);
			answer++;
		}
		if (!isPoss) answer = -1;
		return answer;
	}
}
