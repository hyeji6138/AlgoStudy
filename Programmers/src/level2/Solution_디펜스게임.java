package level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_디펜스게임 {
	public static void main(String[] args) {
		int n = 7, k = 3;
		int[] enemy = { 4, 2, 4, 5, 3, 3, 1 };
		System.out.println(solution(n, k, enemy));
	}

	static public int solution(int n, int k, int[] enemy) {
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < enemy.length; i++) {
			queue.add(enemy[i]);
			if (enemy[i] <= n) {
				n -= enemy[i];
				answer += 1;
			} else {
				if (k == 0) {
					break;
				}
				while (!queue.isEmpty() && k > 0) {
					int x = queue.poll();
					n += x;
					k -= 1;
					if (enemy[i] <= n) {
						n -= enemy[i];
						answer += 1;
						break;
					}
				}
			}
		}
		return answer;
	}
}
