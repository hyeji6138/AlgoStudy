package level0;

public class Solution_문자열정수의합 {
	public static void main(String[] args) {
		String num_str = "123456789";
		System.out.println(solution(num_str));
	}

	public static int solution(String num_str) {
		int answer = 0;
		for (int i = 0; i < num_str.length(); i++) {
			answer += num_str.charAt(i) - '0';
		}
		return answer;
	}
}
