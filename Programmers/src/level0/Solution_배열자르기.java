package level0;

import java.util.Arrays;

public class Solution_배열자르기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		int num1 = 1, num2 = 3;
		System.out.println(Arrays.toString(solution(numbers, num1, num2)));
	}

	public static int[] solution(int[] numbers, int num1, int num2) {
		int[] answer = Arrays.copyOfRange(numbers, num1, num2 + 1);
		return answer;
	}
}
