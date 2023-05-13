package level0;

public class Solution_9로나눈나머지 {
	public static void main(String[] args) {
		String number = "78720646226947352489";
		System.out.println(solution(number));

	}

	public static int solution(String number) {
		int answer = 0;
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += number.charAt(i) - '0';
		}
		answer = sum % 9;
		return answer;
	}
}
