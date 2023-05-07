package level0;

public class Solution_공배수 {
	public static void main(String[] args) {
		int number = 60;
		int n = 2, m = 3;
		System.out.println(solution(number, n, m));
	}

	public static int solution(int number, int n, int m) {
		int answer = 0;
		if (number % n == 0 && number % m == 0) {
			answer = 1;
		}
		return answer;
	}

}
