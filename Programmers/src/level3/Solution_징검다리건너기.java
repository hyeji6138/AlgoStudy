package level3;

public class Solution_징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}
// 효율성 13/14
	public static int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			if (max < stones[i]) {
				max = stones[i];
			}
		}
		answer = Math.min(answer, max);
		for (int i = k; i < stones.length; i++) {
			if (max < stones[i]) {
				max = stones[i];
			} else {
				if (max == stones[i - k]) {
					max = findMax(i, k, stones);
				}
			}
			answer = Math.min(answer, max);
		}
		return answer;
	}

	public static int findMax(int idx, int k, int[] stones) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			if (max < stones[idx - i]) {
				max = stones[idx - i];
			}
		}
		return max;
	}

// 효율성 0/14
//	public static int solution(int[] stones, int k) {
//		int answer = Integer.MAX_VALUE;
//		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < k; i++) {
//			list.add(stones[i]);
//		}
//		answer = Math.min(answer, Collections.max(list));
//		for (int i = k; i < stones.length; i++) {
//			list.remove(0);
//			list.add(stones[i]);
//			answer = Math.min(answer, Collections.max(list));
//		}
//		return answer;
//	}

}
