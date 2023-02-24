package level0;

public class Solution_팩토리얼 {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 1;
		int fact = 1;
		while (fact * answer <= n) {
			fact *= answer;
			answer++;
		}
		return answer - 1;
	}

}
