package level0;

import java.util.Arrays;

public class Solution_배열만들기1 {
	public static void main(String[] args) {
		int n = 10, k = 3;
		System.out.println(Arrays.toString(solution(n, k)));
	}

	public static int[] solution(int n, int k) {
		int[] answer = new int[n / k];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = (i + 1) * k;
		}
		return answer;
	}

}
