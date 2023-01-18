package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_두큐합같게만들기 {
	public static void main(String[] args) {
		int[] queue1 = { 1, 1 };
		int[] queue2 = { 1, 5 };
		System.out.println(solution(queue1, queue2));
	}

	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long sum1 = 0, sum2 = 0;
		int maxCnt = 600000;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		for (int i = 0; i < queue1.length; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];

			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}
		if ((sum1 + sum2) % 2 != 0) {
			answer = -1;
		} else {
			while (sum1 != sum2 && !q1.isEmpty() && !q2.isEmpty() && answer <= maxCnt) {
				if (sum1 < (sum1 + sum2) / 2) {
					int num = q2.poll();
					q1.add(num);
					sum1 += num;
					sum2 -= num;
				} else if (sum2 < (sum1 + sum2) / 2) {
					int num = q1.poll();
					q2.add(num);
					sum2 += num;
					sum1 -= num;
				}
				answer++;
			}

			if (q1.isEmpty() || q2.isEmpty() || answer > maxCnt) {
				answer = -1;
			}
		}
		return answer;
	}

}
