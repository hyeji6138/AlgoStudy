package level0;

import java.math.BigInteger;

public class Solution_구슬을나누는경우의수 {
	public static void main(String[] args) {
		int balls = 30;
		int share = 15;
		System.out.println(solution(balls, share));
	}

	public static int solution(int balls, int share) {
		int answer = 0;
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;

		for (int i = balls - share + 1; i <= balls; i++) {
			a = a.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= share; i++) {
			b = b.multiply(BigInteger.valueOf(i));
		}
		answer = a.divide(b).intValue();
		return answer;
	}

}
