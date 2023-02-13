package level0;

public class Solution_숫자비교하기 {
	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		System.out.println(solution(num1, num2));
	}

	public static int solution(int num1, int num2) {
		int answer = -1;
		if (num1 == num2) {
			answer = 1;
		}
		return answer;
	}
}
