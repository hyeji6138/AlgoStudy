package level2;

public class Solution_피보나치수 {
	public static void main(String[] args) {
		int n = 100000;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		int[] Fibo = new int[n + 1];
		Fibo[0] = 0;
		Fibo[1] = 1;
		if (n == 0 || n == 1) {
			return Fibo[n];
		}

		for (int i = 2; i <= n; i++) {
			Fibo[i] = (Fibo[i - 2] + Fibo[i - 1]) % 1234567;
		}
		answer = Fibo[n];
		return answer;
	}

}
