package level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_프린터 {
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < priorities.length; i++) {
			q.add(new int[] { i, priorities[i] });
		}

		while (true) {
			int max = max(q);
			int[] now = q.poll();
			if (max <= now[1]) {
				answer++;
				if (now[0] == location) break;
			}
			else q.add(now);
			
		}

		return answer;
	}

	public static int max(Queue<int[]> q) {
		int max = 0;
		Iterator<int[]> iter = q.iterator();
		while (iter.hasNext()) {
			int now = iter.next()[1];
			if (max < now)
				max = now;
		}
		return max;
	}
}
