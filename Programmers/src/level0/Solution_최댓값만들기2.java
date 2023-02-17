package level0;

import java.util.Arrays;

public class Solution_최댓값만들기2 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, -3, 4, -5 };
		System.out.println(solution(numbers));
	}

	public static int solution(int[] numbers) {
		int answer = 0;
		int len = numbers.length;
		Arrays.sort(numbers);
		answer = Math.max(numbers[0] * numbers[1], numbers[len - 1] * numbers[len - 2]);
		return answer;
	}

}
