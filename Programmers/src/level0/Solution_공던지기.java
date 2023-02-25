package level0;

public class Solution_공던지기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		int k = 5;
		System.out.println(solution(numbers, k));
	}

	public static int solution(int[] numbers, int k) {
		int answer = 0;
		int idx = 0;
		for (int i = 1; i < k; i++) {
			idx = (idx + 2) % numbers.length;
		}
		answer = numbers[idx];
		return answer;
	}

}
