package level2;

import java.util.Arrays;

public class Solution_k진수에서소수개수구하기 {
	public static void main(String[] args) {
		int n = Integer.MAX_VALUE;
		int k = 3;
		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {
		int answer = 0;
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			sb.insert(0, n % k);
			n = n / k;
		}
		String[] numbers = sb.toString().split("0");
		System.out.println(Arrays.toString(numbers));
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i].length() > 0 && isPrime(Long.parseLong(numbers[i]))) {
				answer++;
			}
		}

		return answer;
	}

	public static boolean isPrime(long n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= (long) Math.sqrt(n); i++) {
			if (n % i == 0 && i != n) {
				return false;
			}
		}
		return true;
	}

}
