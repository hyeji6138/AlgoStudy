package level0;

import java.util.Arrays;

public class Solution_짝수는싫어요 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(Arrays.toString(solution(n)));

	}

	public static int[] solution(int n) {
		int[] answer = new int[n / 2 + n % 2];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = i * 2 + 1;
		}
		return answer;
	}

}
