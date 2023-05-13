package level0;

public class Solution_주사위게임2 {
	public static void main(String[] args) {
		int a = 4, b = 4, c = 4;
		System.out.println(solution(a, b, c));
	}

	public static int solution(int a, int b, int c) {
		int answer = a + b + c;
		if (a == b || b == c || c == a) {
			answer *= (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
			if (a == b && b == c && c == a) {
				answer *= (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
			}
		}
		return answer;
	}

}
