package level2;

import java.util.Stack;

public class Solution_올바른괄호 {
	public static void main(String[] args) {
		String s = "(()(";
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
		boolean answer = true;
		char[] bracket = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < bracket.length; i++) {
			if(bracket[i] == '(') {
				stack.add(bracket[i]);
			}else {
				if(stack.size()>=1) {
					stack.pop();
				}
				else {
					answer = false;
					break;
				}
			}
		}
		if(stack.size() > 0) {
			answer = false;
		}
		return answer;
	}

}
