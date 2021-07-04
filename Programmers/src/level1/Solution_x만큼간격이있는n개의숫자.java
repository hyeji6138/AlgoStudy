package level1;

import java.util.Arrays;

public class Solution_x만큼간격이있는n개의숫자 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10000000, 1000)));
	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		long num = x;
		for (int i = 0; i < n; i++) {
			answer[i] = num + (long) x * i;
		}
		return answer;
	}
}
