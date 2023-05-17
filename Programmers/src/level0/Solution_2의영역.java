package level0;

import java.util.Arrays;

public class Solution_2의영역 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		int[] answer = { -1 };
		int start = 0, end = 0;
		boolean isPos = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				if (!isPos) {
					start = i;
					end = i;
					isPos = true;
				} else {
					end = i;
				}
			}
		}
		if (isPos) {
			answer = Arrays.copyOfRange(arr, start, end + 1);
		}
		return answer;
	}

}
