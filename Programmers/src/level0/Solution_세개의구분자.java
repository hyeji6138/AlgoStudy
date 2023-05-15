package level0;

import java.util.Arrays;

public class Solution_세개의구분자 {
	public static void main(String[] args) {
		String myStr = "cabab";
		System.out.println(Arrays.toString(solution(myStr)));
	}

	public static String[] solution(String myStr) {
		String[] spl = myStr.split("a|b|c");
		int cnt = 0;
		for (int i = 0; i < spl.length; i++) {
			if (spl[i].length() > 0) {
				cnt++;
			}
		}
		String[] answer;
		if (cnt < 1) {
			answer = new String[1];
			answer[0] = "EMPTY";
		} else {
			answer = new String[cnt];
			cnt = 0;
			for (int i = 0; i < spl.length; i++) {
				if (spl[i].length() > 0) {
					answer[cnt++] = spl[i];
				}
			}
		}
		return answer;
	}

}
