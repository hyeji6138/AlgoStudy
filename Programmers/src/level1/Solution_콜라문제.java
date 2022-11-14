package level1;

public class Solution_콜라문제 {
	public static void main(String[] args) {
		int a = 3;
		int b = 1;
		int n = 20;
		System.out.println(solution(a, b, n));
	}

	public static int solution(int a, int b, int n) {
		int answer = 0;
		while (n >= a) {
			int response = (n / a) * b;
			answer += response;
			n = n % a +response;
		}
		return answer;
	}

}
