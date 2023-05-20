package level2;

import java.util.Arrays;

public class Solution_뒤에있는큰수찾기 {
	public static void main(String[] args) {
		int[] numbers = { 8, 1, 2, 9 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		answer[answer.length - 1] = -1;
		for (int i = answer.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < answer.length; j++) {
				if (numbers[i] < numbers[j]) { // 가장 가까운 큰 수
					answer[i] = numbers[j];
					break;
				} else {
					if (numbers[i] < answer[j] || answer[j] == -1) { // j번째까지 가장 가까운 큰수가 있거나 아예 없거나
						answer[i] = answer[j];
						break;
					}
				}
			}
		}
		return answer;
	}

}
