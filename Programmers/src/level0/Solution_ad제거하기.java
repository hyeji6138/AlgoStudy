package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_ad제거하기 {
	public static void main(String[] args) {
		String[] strArr = { "and", "notad", "abcd" };
		System.out.println(Arrays.toString(solution(strArr)));
	}

	public static String[] solution(String[] strArr) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].contains("ad")) {
				list.add(strArr[i]);
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
