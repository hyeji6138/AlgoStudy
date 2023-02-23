package level0;

public class Solution_피자나눠먹기2 {
	public static void main(String[] args) {
		int n = 1000;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		int temp = 1; // 6이랑 n의 최대공배수
		int a = 6, b = n;
		for (int i = 2; i <= Math.max(a, b);) {
			if (a % i == 0 && b % i == 0) {
				temp *= i;
				a /= i;
				b /= i;
			} else if (a % i == 0) {
				temp *= i;
				a /= i;
			} else if (b % i == 0) {
				temp *= i;
				b /= i;
			} else {
				i++;
			}
		}
		answer = temp / 6;
		return answer;
	}
}
