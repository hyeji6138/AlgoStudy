package level2;

public class Solution_멀쩡한사각형 {
	public static void main(String[] args) {
		int W = 1000000000;
		int H = 99999999;
		System.out.println(solution(W, H));
	}

	public static long solution(int w, int h) {
		long answer = 0;
		int gcd = GCD(h, w);
		answer = (long) w * (long) h - (w + h - gcd);
		return answer;
	}

	public static int GCD(int n, int m) {
		int result = 1;
		for (int i = 2; i <= Math.min(n, m);) {
			if (n % i == 0 && m % i == 0) {
				result *= i;
				n /= i;
				m /= i;
			} else {
				i++;
			}
		}
		return result;
	}
}
