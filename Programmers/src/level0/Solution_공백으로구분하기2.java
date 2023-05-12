package level0;

import java.util.Arrays;

public class Solution_공백으로구분하기2 {
	public static void main(String[] args) {
		String my_string = "i   love you";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	public static String[] solution(String my_string) {
		String[] temp = my_string.split(" ");
		int cnt = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].length() > 0) {
				cnt++;
			}
		}
		String[] answer = new String[cnt];
		cnt = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].length() > 0) {
				answer[cnt++] = temp[i];
			}
		}
		return answer;
	}

}
