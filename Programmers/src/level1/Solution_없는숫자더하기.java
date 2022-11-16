package level1;

public class Solution_없는숫자더하기 {
	public static void main(String[] args) {
		int[] numbers = {5,8,4,0,6,7,9};
		System.out.println(solution(numbers));
	}

	public static int solution(int[] numbers) {
		int answer = 0;
		boolean[] num = new boolean[10];
		for (int i = 0; i < numbers.length; i++) {
			num[numbers[i]] = true;
		}
		for (int i = 0; i <= 9; i++) {
			if (!num[i]) {
				answer += i;
			}
		}

		return answer;
	}
}
