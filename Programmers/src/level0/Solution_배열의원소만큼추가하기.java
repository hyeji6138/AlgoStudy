package level0;

import java.util.Arrays;

public class Solution_배열의원소만큼추가하기 {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 4 };
		System.out.println(Arrays.toString(solution(arr)));

	}

	public static int[] solution(int[] arr) {
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			len += arr[i];
		}
		int[] answer = new int[len];
		int std = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i]; j++) {
				answer[j + std] = arr[i];
			}
			std += arr[i];
		}
		return answer;
	}

}
