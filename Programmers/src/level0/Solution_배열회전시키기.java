package level0;

import java.util.Arrays;

public class Solution_배열회전시키기 {
	public static void main(String[] args) {
		int[] numbers = { 4, 455, 6, 4, -1, 45, 6 };
		String direction = "left";
		System.out.println(Arrays.toString(solution(numbers, direction)));
	}

	public static int[] solution(int[] numbers, String direction) {
		int[] answer = new int[numbers.length];
		if (direction.equals("right")) {// 오른쪽 회전
			for (int i = 1; i < numbers.length; i++) {
				answer[i] = numbers[i - 1];
			}
			answer[0] = numbers[numbers.length - 1];
		} else { // 왼쪽 회전
			for (int i = 0; i < numbers.length - 1; i++) {
				answer[i] = numbers[i + 1];
			}
			answer[numbers.length - 1] = numbers[0];
		}
		return answer;
	}

}
