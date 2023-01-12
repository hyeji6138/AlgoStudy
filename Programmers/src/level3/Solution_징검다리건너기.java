package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}

	public static int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(stones[i]);
		}
		answer = Math.min(answer, Collections.max(list));
		for (int i = k; i < stones.length; i++) {
			list.remove(0);
			list.add(stones[i]);
			answer = Math.min(answer, Collections.max(list));
		}
		return answer;
	}

}
