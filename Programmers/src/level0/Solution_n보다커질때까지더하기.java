package level0;

public class Solution_n보다커질때까지더하기 {
	public static void main(String[] args) {
		int[] numbers = { 58, 44, 27, 10, 100 };
		int n = 139;
		System.out.println(solution(numbers, n));
	}

	public static int solution(int[] numbers, int n) {
		int answer = 0;
		for (int i = 0; i < numbers.length && answer <= n; i++) {
			answer += numbers[i];
		}
		return answer;
	}

}
