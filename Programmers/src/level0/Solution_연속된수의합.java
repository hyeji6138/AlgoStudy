package level0;

import java.util.Arrays;

public class Solution_연속된수의합 {
	public static void main(String[] args) {
		int num = 5, total = 5;
		System.out.println(Arrays.toString(solution(num, total)));
	}

	public static int[] solution(int num, int total) {
		int[] answer = new int[num];
		for (int i = 0, n = total / num - (num - 1) / 2; i < num; i++) {
			answer[i] = n + i;
		}
		return answer;
	}

}
