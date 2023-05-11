package level0;

import java.util.Arrays;

public class Solution_배열의길이에따라다른연산하기 {
	public static void main(String[] args) {
		int[] arr = { 49, 12, 100, 276, 33 };
		int n = 27;
		System.out.println(Arrays.toString(solution(arr, n)));
	}

	public static int[] solution(int[] arr, int n) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
			if (arr.length % 2 == 0 && i % 2 != 0) {
				answer[i] += n;
			} else if (arr.length % 2 != 0 && i % 2 == 0) {
				answer[i] += n;
			}
		}
		return answer;
	}

}
