package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_숫자게임 {
	public static void main(String[] args) {
		int[] A = { 5, 1, 3, 7 }, B = { 2, 2, 6, 8 };
		System.out.println(solution(A, B));
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int aIndex = 0, bIndex = 0;
		while (bIndex < B.length) {
			if (A[aIndex] < B[bIndex]) {
				answer++;
				aIndex++;
			}
			bIndex++;
		}
		return answer;
	}
	
	/* 뭔가 잘 안됨 
	public static int solution2(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(B);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			list.add(B[i]);
		}
		for (int i = 0; i < A.length; i++) {
			answer += binarySearch(0, list.size() - 1, A[i], list);
		}
		return answer;
	}

	public static int binarySearch(int left, int right, int num, List<Integer> list) {
		int result = 0;
		if (left == right) { // 자리 찾음
			if (left < list.size() && num < list.get(right)) {
				result = 1;
			} else if (num == list.get(right)) {
				int temp = right + 1;
				while (temp < list.size()) {
					if (num < list.get(temp)) {
						result = 1;
						right = temp;
						break;
					}
					temp++;
				}
			}
			list.remove(right);
		} else if (list.get((left + right) / 2) < num) {
			result = binarySearch((left + right) / 2 + 1, right, num, list);
		} else {
			result = binarySearch(left, (left + right) / 2, num, list);
		}
		return result;
	}*/

}
