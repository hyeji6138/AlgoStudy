package level0;

public class Solution_두수의연산값비교하기 {
	public static void main(String[] args) {
		int a = 2, b = 91;
		System.out.println(solution(a, b));
	}

	public static int solution(int a, int b) {
		int answer = Math.max(Integer.parseInt(a + "" + b), 2 * a * b);
		return answer;
	}

}
