package level2;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_귤고르기 {
	public static void main(String[] args) {
		int k = 6;
		int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };
		System.out.println(solution(k, tangerine));
	}

	public static int solution(int k, int[] tangerine) {
		int answer = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < tangerine.length; i++) {
			if (hashMap.containsKey(tangerine[i])) {
				hashMap.replace(tangerine[i], hashMap.get(tangerine[i]) + 1);
			} else {
				hashMap.put(tangerine[i], 1);
			}
		}
		int[] cnt = new int[hashMap.size()];
		int idx = 0;
		for (Integer i : hashMap.keySet()) {
			cnt[idx++] = hashMap.get(i);
		}
		Arrays.sort(cnt);
		for (int i = cnt.length - 1, sum = 0; i >= 0; i--) {
			if (sum < k) {
				sum += cnt[i];
				answer++;
			}
		}

		return answer;
	}

}
