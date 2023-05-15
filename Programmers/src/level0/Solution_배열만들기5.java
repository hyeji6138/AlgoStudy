package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_배열만들기5 {
	public static void main(String[] args) {
		String[] intStrs = { "0123456789", "9876543210", "9999999999999" };
		int k = 50000, s = 5, l = 5;
		System.out.println(Arrays.toString(solution(intStrs, k, s, l)));
	}

	public static int[] solution(String[] intStrs, int k, int s, int l) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < intStrs.length; i++) {
			int num = Integer.parseInt(intStrs[i].substring(s, s + l));
			if (num > k) {
				list.add(num);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
