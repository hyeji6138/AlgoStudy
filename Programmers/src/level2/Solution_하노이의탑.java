package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_하노이의탑 {
	static List<int[]> step;

	public static void main(String[] args) {
		int n = 15;
		int[][] result = solution(n);
		for (int i = 0; i < result.length; i++) {
			System.out.print(Arrays.toString(result[i]) + " ");
		}

	}

	public static int[][] solution(int n) {
		step = new ArrayList<>();
		hanoi(1, 3, n);
		int[][] answer = new int[step.size()][2];
		for (int i = 0; i < step.size(); i++) {
			answer[i] = step.get(i);
		}
		return answer;
	}

	public static void hanoi(int start, int end, int n) {
		if (n == 1) {
			step.add(new int[] { start, end });
			return;
		}
		int temp = 0;
		for (int i = 1; i <= 3; i++) {
			if (i != start && i != end) {
				temp = i;
			}
		}
		hanoi(start, temp, n - 1);
		step.add(new int[] { start, end });
		hanoi(temp, end, n - 1);
	}

}
