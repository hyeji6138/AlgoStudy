package level0;

public class Solution_flag에따라다른값반환하기 {
	public static void main(String[] args) {
		int a = -4, b = 7;
		boolean flag = true;
		System.out.println(solution(a, b, flag));
	}

	public static int solution(int a, int b, boolean flag) {
		int answer = 0;
		if (flag) {
			answer = a + b;
		} else {
			answer = a - b;
		}
		return answer;
	}

}
