package level2;

import java.util.Stack;

public class Solution_택배상자 {
	public static void main(String[] args) {
		int[] order = { 4, 3, 1, 2, 5 };
		System.out.println(solution(order));
	}

	public static int solution(int[] order) {
		int answer = 0;
		Stack<Integer> container = new Stack<>();
		int i = 0, num = 1;
		while (i < order.length) {
//			System.out.println("num: " + num + ", order: " + order[i]);
			if (num == order[i]) {
//				System.out.println(">> box in");
				answer++;
				num++;
				i++;
			} else {
				if (!container.isEmpty() && container.peek() == order[i]) {
//					System.out.println("container pop: " + container.pop() + " " + order[i]);
					container.pop();
					answer++;
					i++;
				} else if (num <= order.length) {
//					System.out.println("container put: " + num);
					container.add(num);
					num++;
				} else {
//					System.out.println("end: " + num + " " + order[i]);
					break;
				}
			}
		}

//		for (int i = 0, num = 1; num <= order.length; num++) {
//			System.out.println(num + " " + order[i]);
//			if (num == order[i]) {
//				answer++;
//				i++;
//			} else {
//				if (!container.isEmpty() && container.peek() == order[i]) {
//					container.pop();
//					answer++;
//					i++;
//				} else {
//					System.out.println("stack put: " + num);
//					container.add(num);
//				}
//			}
//		}
		return answer;
	}

}
