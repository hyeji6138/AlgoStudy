package level0;

import java.util.Arrays;
import java.util.Stack;

public class Solution_배열만들기6 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 1, 0 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		int[] answer = { -1 };
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length;) {
			if (stack.isEmpty()) {
				stack.add(arr[i++]);
			} else if (stack.peek() == arr[i]) {
				stack.pop();
				i++;
			} else {
				stack.add(arr[i++]);
			}
		}
		if (!stack.isEmpty()) {
			answer = new int[stack.size()];
			for (int i = answer.length - 1; i >= 0; i--) {
				answer[i] = stack.pop();
			}
		}
		return answer;
	}

}
