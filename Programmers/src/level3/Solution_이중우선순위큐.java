package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_이중우선순위큐 {
	static List<Integer> queue;

	public static void main(String[] args) {
		String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 30", "D 1", "D -1", "I 333" };
		System.out.println(Arrays.toString(solution(operations)));

	}

	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		queue = new ArrayList<>();
		for (int i = 0; i < operations.length; i++) {
			String[] op = operations[i].split(" ");
			if (op[0].equals("I")) {
				insert(Integer.parseInt(op[1]), 0, queue.size());
			} else {
				delete(Integer.parseInt(op[1]));
			}
		}
		if (!queue.isEmpty()) {
			answer[0] = queue.get(queue.size() - 1);
			answer[1] = queue.get(0);
		}
		return answer;
	}

	public static void insert(int n, int left, int right) {
		if (left == right) {
			queue.add(left, n);
		} else if (n < queue.get((left + right) / 2)) {
			insert(n, left, (left + right) / 2);
		} else {
			insert(n, (left + right) / 2 + 1, right);
		}
	}

	public static void delete(int op) {
		if (!queue.isEmpty()) {
			if (op == -1) {
				queue.remove(0);
			} else {
				queue.remove(queue.size() - 1);
			}
		}
	}

}
