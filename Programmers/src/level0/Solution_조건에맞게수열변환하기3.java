package level0;

import java.util.Arrays;

public class Solution_조건에맞게수열변환하기3 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 100, 99, 98 };
		int k = 3;
		System.out.println(Arrays.toString(solution(arr, k)));
	}

	public static int[] solution(int[] arr, int k) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (k % 2 != 0) {
				answer[i] = arr[i] * k;
			} else {
				answer[i] = arr[i] + k;
			}
		}
		return answer;
	}

}
