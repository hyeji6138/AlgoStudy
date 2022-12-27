package level3;

import java.util.Arrays;

public class Solution_최고의집합 {
	public static void main(String[] args) {
		int n = 4, s = 15;
		System.out.println(Arrays.toString(solution(n, s)));
	}

	public static int[] solution(int n, int s) {
		int[] answer = new int[1];
		if (s / n == 0) {
			answer[0] = -1;
		} else {
			answer = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				answer[i] = s / (i + 1);
				if (s % (i + 1) > 0) {
					answer[i]++;
				}
				s -= answer[i];
			}
		}
		return answer;
	}

}
