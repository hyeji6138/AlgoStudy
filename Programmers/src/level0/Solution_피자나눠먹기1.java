package level0;

public class Solution_피자나눠먹기1 {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		answer = n / 7;
		if (n % 7 != 0) {
			answer += 1;
		}
		return answer;
	}

}
