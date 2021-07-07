package level2;

import java.util.Arrays;
import java.util.Stack;

public class Solution_기능개발 {
	public static void main(String[] args) {
		int[] progresses = { 95, 90, 99, 99, 80, 99 }, speeds = { 1, 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int now = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < progresses.length; i++) {
			int day = 1;
			while (speeds[i] * day + progresses[i] < 100) {
				day++;
			}
			if (day <= now) {
				stack.add(stack.pop() + 1);
			} else {
				stack.add(1);
				now = day;
			}
		}
		answer = new int[stack.size()];
		int i = stack.size() - 1;
		while (!stack.isEmpty()) {
			answer[i--] = stack.pop();
		}
		return answer;
	}
}
