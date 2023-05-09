package level0;

public class Solution_더크게합치기 {
	public static void main(String[] args) {
		int a = 9, b = 91;
		System.out.println(solution(a, b));
	}

	public static int solution(int a, int b) {
		int answer = 0;
		int ab = Integer.parseInt("" + a + b);
		int ba = Integer.parseInt("" + b + a);
		answer = Math.max(ab, ba);
		return answer;
	}

}
