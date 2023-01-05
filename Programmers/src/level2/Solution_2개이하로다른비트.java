package level2;

import java.util.Arrays;

public class Solution_2개이하로다른비트 {
	static int[] select;
	static long next;

	public static void main(String[] args) {
		long[] numbers = { 2, 7 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	public static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) { // 짝수
				answer[i] = numbers[i] + 1;
			} else { // 홀수
				StringBuffer bit1 = new StringBuffer(Long.toBinaryString(numbers[i]));
				int zero = bit1.length();
				for (int j = bit1.length() - 1; j >= 0; j--) {
					if (bit1.charAt(j) == '0') {
						zero = bit1.length() - 1 - j;
						break;
					}
				}
				int one = zero - 1;
				answer[i] = numbers[i] + (long) Math.pow(2, zero) - (long) Math.pow(2, one);

			}
		}
		return answer;
	}

	public static boolean check(String s1, String s2) {
		int idx1 = s1.length() - 1, idx2 = s2.length() - 1, cnt = 0;
		while (cnt <= 2 && idx1 >= 0 && idx2 >= 0) {
			if (s1.charAt(idx1--) != s2.charAt(idx2--)) {
				cnt++;
			}
		}
		if (idx2 >= 0) {
			cnt++;
		}
		if (cnt > 2) {
			return false;
		}
		return true;
	}

}
