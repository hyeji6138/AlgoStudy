package level0;

public class Solution_간단한식계산하기 {
	public static void main(String[] args) {
		String binomial = "40000 * 40000";
		System.out.println(solution(binomial));
	}

	public static int solution(String binomial) {
		int answer = 0;
		String[] elements = binomial.split(" ");
		switch (elements[1]) {
		case "+":
			answer = Integer.parseInt(elements[0]) + Integer.parseInt(elements[2]);
			break;
		case "-":
			answer = Integer.parseInt(elements[0]) - Integer.parseInt(elements[2]);
			break;
		case "*":
			answer = Integer.parseInt(elements[0]) * Integer.parseInt(elements[2]);
			break;
		default:
			break;
		}
		return answer;
	}
}
