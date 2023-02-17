package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_문자열정렬하기1 {
	public static void main(String[] args) {
		String my_string = "hi12392";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	public static int[] solution(String my_string) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < my_string.length(); i++) {
			char x = my_string.charAt(i);
			if (Character.isDigit(x)) {
				list.add(x - '0');
			}
		}
		Collections.sort(list);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
