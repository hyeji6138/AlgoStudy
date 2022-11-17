package level1;

public class Solution_기사단원의무기 {
	public static void main(String[] args) {
		int number = 5;
		int limit = 3;
		int power = 2;
		System.out.println(solution(number, limit, power));
	}

	public static int solution(int number, int limit, int power) {
		int answer = 0;
		for (int n = 1; n <= number; n++) {
			int divisor = 0;
			for (int i = 1; i <= (int) Math.sqrt(n); i++) {
				if (n % i == 0) {
					if (i * i == n) {
						divisor += 1;
					} else {
						divisor += 2;
					}
				}
			}
			if (divisor <= limit) {
				answer += divisor;
			} else {
				answer += power;
			}

		}
		return answer;
	}

}
