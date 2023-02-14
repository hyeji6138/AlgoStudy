package level0;

public class Solution_배열의평균값 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(solution(numbers));
	}

	public static double solution(int[] numbers) {
		double answer = 0;
		for (int i = 0; i < numbers.length; i++) {
			answer += numbers[i];
		}
		answer = answer / numbers.length;
		return answer;
	}

}
