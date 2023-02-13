package level0;

public class Solution_두수의나눗셈 {
	public static void main(String[] args) {
		int num1 = 3, num2 = 2;
		System.out.println(solution(num1, num2));
	}

	public static int solution(int num1, int num2) {
		int answer = 0;
		double div = (double) num1 / num2;
		answer = (int) (div * 1000);
		return answer;
	}

}
