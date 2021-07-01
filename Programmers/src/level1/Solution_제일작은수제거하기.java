package level1;

import java.util.Arrays;

public class Solution_제일작은수제거하기 {
	public static void main(String[] args) {
		int[] arr = {10};
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		int[] answer = { -1 };
		if (arr.length - 1 > 0) {
			answer = new int[arr.length - 1];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				min = Math.min(min, arr[i]);
			}
			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != min) {
					answer[idx++] = arr[i];
				}
			}
		}
		return answer;
	}
}
