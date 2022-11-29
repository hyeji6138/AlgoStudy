package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_주식가격 {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		System.out.println(Arrays.toString(solution(prices)));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < prices.length; i++) {
			queue.add(new int[] { i, 0 });
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();
				if (prices[p[0]] > prices[i]) {
					answer[p[0]] = p[1];
				} else {
					queue.add(new int[] { p[0], p[1] + 1 });
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			answer[p[0]] = p[1] - 1;
		}
		return answer;
	}

}
