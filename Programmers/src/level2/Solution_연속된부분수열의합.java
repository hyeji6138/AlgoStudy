package level2;

import java.util.Arrays;

public class Solution_연속된부분수열의합 {
	public static void main(String[] args) {
		int[] sequence = { 1, 1, 1, 2, 3, 4, 5 };
		int k = 5;
		System.out.println(Arrays.toString(solution(sequence, k)));
	}

	public static int[] solution(int[] sequence, int k) {
		int[] answer = { 0, Integer.MAX_VALUE };
		int start = 0, end = 0, sum = 0;
		sum = sequence[0];
		while (start < sequence.length && end < sequence.length) {
			if (sum == k && (end - start) < (answer[1] - answer[0])) { // 합이 k이고 부분 수열 길이가 더 짧을 때
				answer[0] = start;
				answer[1] = end;
			}

			if (sum < k) {
				end += 1;
				if (end < sequence.length) {
					sum += sequence[end];
				}
			} else {
				sum -= sequence[start];
				start += 1;
			}

		}
		return answer;
	}

}
