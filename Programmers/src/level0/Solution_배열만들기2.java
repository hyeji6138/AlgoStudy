package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_배열만들기2 {
	public static void main(String[] args) {
		int l = 1, r = 1000000;
		System.out.println(Arrays.toString(solution(l, r)));
	}

	public static int[] solution(int l, int r) {
		int[] answer = { -1 };
		List<Integer> list = new ArrayList<>();
		for (int i = l; i <= r; i++) {
			if (i % 5 != 0) continue;
			int n = i;
			while (n > 0 && (n % 10 == 5 || n % 10 == 0)) {
				n /= 10;
			}
			if (n == 0) {
				list.add(i);
			}
		}
		if (list.size() > 0) {
			answer = new int[list.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}
		}
		return answer;
	}

}
