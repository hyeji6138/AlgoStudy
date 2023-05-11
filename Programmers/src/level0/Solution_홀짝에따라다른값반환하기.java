package level0;

public class Solution_홀짝에따라다른값반환하기 {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		if (n % 2 == 0) {
			for (int i = 2; i <= n; i += 2) {
				answer += i * i;
			}
		} else {
			for (int i = 1; i <= n; i += 2) {
				answer += i;
			}
		}
		return answer;
	}

}
