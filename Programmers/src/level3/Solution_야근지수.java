package level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_야근지수 {
	public static void main(String[] args) {
		int[] works = { 800, 100, 55, 45 };
		int n = 999;
		System.out.println(solution(n, works));
	}

	public static long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < works.length; i++) {
			queue.add(works[i]);
		}
		while (n > 0 && !queue.isEmpty()) {
			int work = queue.poll();
			if (work > 0) {
				queue.add(work - 1);
				n--;
			}
		}
		while (!queue.isEmpty()) {
			int work = queue.poll();
			answer += work * work;
		}
		return answer;
	}

}
