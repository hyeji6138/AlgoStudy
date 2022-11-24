package level2;

import java.util.Stack;

public class Solution_괄호회전하기 {
	public static void main(String[] args) {
		String s = "[)(]";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			String bracket = s.substring(i) + s.substring(0, i);
			if (isBracket(bracket)) {
				answer++;
			}
		}
		return answer;
	}

	public static boolean isBracket(String s) {
		Stack<Character> stack = new Stack<>();
		char[] bracket = s.toCharArray();
		for (int i = 0; i < bracket.length; i++) {
			if (bracket[i] == '(' || bracket[i] == '[' || bracket[i] == '{') {
				stack.add(bracket[i]);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char pair = stack.pop();
				switch (bracket[i]) {
				case ')':
					if (pair != '(') {
						return false;
					}
					break;
				case '}':
					if (pair != '{') {
						return false;
					}
					break;
				case ']':
					if (pair != '[') {
						return false;
					}
					break;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

}
