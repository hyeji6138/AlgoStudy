package level0;

import java.util.Arrays;

public class Solution_문자열잘라서정렬하기 {
	public static void main(String[] args) {
		String myString = "axbxcxdxxxax";
		System.out.println(Arrays.toString(solution(myString)));
	}

	public static String[] solution(String myString) {
		String[] x = myString.split("x");
		int cnt = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i].length() > 0) {
				cnt++;
			}
		}
		String[] answer = new String[cnt];
		cnt = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i].length() > 0) {
				answer[cnt++] = x[i];
			}
		}
		Arrays.sort(answer);
		return answer;
	}

}
