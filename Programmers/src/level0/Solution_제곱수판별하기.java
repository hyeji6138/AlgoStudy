package level0;

public class Solution_제곱수판별하기 {
	public static void main(String[] args) {
		int n = 976;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 2;
		if (n % Math.sqrt(n) == 0) {
			answer = 1;
		}
		return answer;
	}

}
