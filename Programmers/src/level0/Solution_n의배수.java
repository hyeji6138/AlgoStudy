package level0;

public class Solution_n의배수 {
	public static void main(String[] args) {
		int num = 98, n = 2;
		System.out.println(solution(num, n));
	}

	public static int solution(int num, int n) {
		int answer = 0;
		if (num % n == 0) {
			answer = 1;
		}
		return answer;
	}

}
