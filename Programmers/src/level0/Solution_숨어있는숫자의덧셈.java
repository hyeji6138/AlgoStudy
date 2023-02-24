package level0;

public class Solution_숨어있는숫자의덧셈 {
	public static void main(String[] args) {
		String my_string = "111";
		System.out.println(solution(my_string));
	}

	public static int solution(String my_string) {
		int answer = 0;
		boolean isNumber = false;
		int num = 0;
		for (int i = 0; i < my_string.length(); i++) {
			char x = my_string.charAt(i);
			if (!isNumber && Character.isDigit(x)) {
				num += x - '0';
				isNumber = true;
			} else if (isNumber && Character.isDigit(x)) {
				num = num * 10 + (x - '0');
			} else {
				answer += num;
				num = 0;
			}
		}
		if (num > 0) {
			answer += num;
		}
		return answer;
	}

}
