package level0;

import java.util.Arrays;

public class Solution_배열조각하기 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		int[] query = { 4, 1, 2 };
		System.out.println(Arrays.toString(solution(arr, query)));
	}

	public static int[] solution(int[] arr, int[] query) {
		int start = 0, end = arr.length;
		for (int i = 0; i < query.length; i++) {
			if (i % 2 == 0) {// 짝수 - 뒷부분 자르기
				end = start + query[i];
			} else { // 홀수 - 앞부분 자르기
				start = start + query[i];
			}
		}
		int[] answer = new int[end - start + 1];
		for (int i = start, idx = 0; i <= end; i++) {
			answer[idx++] = arr[i];
		}
		return answer;
	}

}
