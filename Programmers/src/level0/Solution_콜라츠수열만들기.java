package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_콜라츠수열만들기 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(n);
		int now = n;
		while (now > 1) {
			if (now % 2 == 0) {
				now = now / 2;
			} else {
				now = now * 3 + 1;
			}
			list.add(now);
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
