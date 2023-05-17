package level0;

import java.util.Arrays;

public class Solution_배열의길이를2의거듭제곱으로만들기 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		int len = 1;
		while (arr.length > len) {
			len *= 2;
		}
		int[] answer = new int[len];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}
		return answer;
	}

}
