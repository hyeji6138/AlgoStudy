package level1;

public class Solution_소수찾기 {
	public static void main(String[] args) {
		System.out.println(solution(1000000));
	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) answer++;
		}
		return answer;
	}

	public static boolean isPrime(int n) {
		int cnt = 0;
		for (int i = 1; i*i <= n; i++) {
			if (n % i == 0) {
				if(i*i == n) cnt++;
				else cnt += 2;
			}
			if(cnt > 2) break;
		}
		return cnt == 2;
	}
}
