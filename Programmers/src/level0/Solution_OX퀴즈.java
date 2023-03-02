package level0;

import java.util.Arrays;

public class Solution_OX퀴즈 {
	public static void main(String[] args) {
		String[] quiz = { "19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2" };
		System.out.println(Arrays.toString(solution(quiz)));
	}

	public static String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];
		for (int i = 0; i < quiz.length; i++) {
			String[] elements = quiz[i].split(" ");
			int a = Integer.parseInt(elements[0]), b = Integer.parseInt(elements[2]);
			int result = 0;
			if (elements[1].equals("+")) {
				result = a + b;
			} else {
				result = a - b;
			}
			if (result == Integer.parseInt(elements[4])) {
				answer[i] = "O";
			} else {
				answer[i] = "X";
			}
		}
		return answer;
	}

}
