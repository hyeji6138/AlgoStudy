package level0;

import java.util.Arrays;
import java.util.Stack;

public class Solution_빈배열에추가삭제하기 {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 1, 3 };
		boolean[] flag = { true, false, true, false, false };
		System.out.println(Arrays.toString(solution(arr, flag)));
	}

	public static int[] solution(int[] arr, boolean[] flag) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (flag[i]) {
				for (int j = 0; j < arr[i] * 2; j++) {
					stack.add(arr[i]);
				}
			} else {
				for (int j = 0; j < arr[i]; j++) {
					stack.pop();
				}
			}
		}
		int[] answer = new int[stack.size()];
		for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}
		return answer;
	}

}
