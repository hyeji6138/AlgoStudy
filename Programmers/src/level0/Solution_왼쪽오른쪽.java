package level0;

import java.util.Arrays;

public class Solution_왼쪽오른쪽 {
	public static void main(String[] args) {
		String[] str_list = { "u", "u", "l", "r" };
		System.out.println(Arrays.toString(solution(str_list)));
	}

	public static String[] solution(String[] str_list) {
		String[] answer = {};
		boolean left = false;
		int idx = -1;
		for (int i = 0; i < str_list.length; i++) {
			if (str_list[i].equals("l")) {
				left = true;
				idx = i;
				break;
			} else if (str_list[i].equals("r")) {
				idx = i;
				break;
			}
		}
		if (idx >= 0) {
			if (left) {
				answer = Arrays.copyOf(str_list, idx);
			} else {
				answer = Arrays.copyOfRange(str_list, idx + 1, str_list.length);
			}
		}
		return answer;
	}

}
