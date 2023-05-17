package level0;

import java.util.Arrays;
import java.util.Stack;

public class Solution_배열만들기4 {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 3 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		int[] stk = {};
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length;) {
			if (stack.isEmpty()) {
				stack.add(arr[i++]);
			} else {
				if (stack.peek() < arr[i]) {
					stack.add(arr[i++]);
				} else {
					stack.pop();
				}
			}
		}
		stk = new int[stack.size()];
		for (int i = stk.length - 1; i >= 0; i--) {
			stk[i] = stack.pop();
		}
		return stk;
	}

}
