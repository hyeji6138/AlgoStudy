package level1;

import java.util.Stack;

public class Solution_햄버거만들기 {
	public static void main(String[] args) {
		int[] ingredient = { 1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1 };
		System.out.println(solution(ingredient));
	}

	public static int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> burger = new Stack<>();
		int[] step = { 1, 2, 3, 1 };
		for (int i = 0; i < ingredient.length; i++) {
			stack.add(ingredient[i]);
			if (stack.peek() == 1 && stack.size() >= 4) {
				boolean check = true;
				for (int j = 3; j >= 0; j--) {
					burger.add(stack.pop());
					if (burger.peek() != step[j]) {
						check = false;
						break;
					}
				}
				if (check) {
					answer++;
					burger.clear();
				} else {
					while (!burger.isEmpty()) {
						stack.add(burger.pop());
					}
				}
			}
		}
		return answer;
	}

}
