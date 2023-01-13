package level3;

public class Solution_징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}

// 이진탐색
	public static int solution(int[] stones, int k) {
		int left = 1, right = 200000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < stones.length; i++) {
				if (stones[i] - mid <= 0) {
					cnt++;
				} else {
					cnt = 0;
				}

				if (cnt == k) {
					break;
				}
			}
			if (cnt == k) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

// 효율성 13/14
//	public static int solution(int[] stones, int k) {
//		int answer = Integer.MAX_VALUE;
//		int maxIdx = 0;
//		for (int i = 0; i < k; i++) {
//			if (stones[maxIdx] <= stones[i]) {
//				maxIdx = i;
//			}
//		}
//		answer = Math.min(answer, stones[maxIdx]);
//		for (int i = k; i < stones.length; i++) {
//			if (stones[maxIdx] <= stones[i]) {
//				maxIdx = i;
//			} else {
//				if (maxIdx == i - k) {
//					maxIdx = findMax(i, k, stones);
//				}
//			}
//			answer = Math.min(answer, stones[maxIdx]);
//		}
//		return answer;
//	}
//
//	public static int findMax(int idx, int k, int[] stones) {
//		int maxIdx = idx;
//		for (int i = 0; i < k; i++) {
//			if (stones[maxIdx] < stones[idx - i]) {
//				maxIdx = idx - i;
//			}
//		}
//		return maxIdx;
//	}

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
