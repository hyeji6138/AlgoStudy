package level0;

public class Solution_숨어있는숫자의덧셈1 {
	public static void main(String[] args) {
		String my_string = "aAb1B2cC34oOp";
		System.out.println(solution(my_string));
	}

	public static int solution(String my_string) {
		int answer = 0;
		for (int i = 0; i < my_string.length(); i++) {
			char x = my_string.charAt(i);
			if (Character.isDigit(x)) {
				answer += x - '0';
			}
		}
		return answer;
	}

}
