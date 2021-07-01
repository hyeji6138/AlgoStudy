package level1;

public class Solution_약수의합 {
	public static void main(String[] args) {
		System.out.println(solution(1));
	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i*i <= n; i++) {
			if (n % i == 0) {
				if(i*i == n) answer += i;
				else answer += i + (n / i);
			}
		}
		return answer;
	}
}
