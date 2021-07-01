package level1;

public class Solution_자릿수더하기 {
	public static void main(String[] args) {
		System.out.println(solution(987));
	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 10; n > 0; n /= i) {
			answer += n % i;
		}
		return answer;
	}
}
