package level2;

import java.util.Arrays;

public class Solution_이진변환반복하기 {
	public static void main(String[] args) {
		String s = "1111111";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		int[] answer = new int[2];
		int time = 0, zero = 0;
		while (!s.equals("1")) {
			char[] num = s.toCharArray();
			int one = 0;
			for (int i = 0; i < num.length; i++) {
				if (num[i] == '1') {
					one++;
				} else {
					zero++;
				}
			}
			s = Integer.toBinaryString(one);
			time++;
		}
		answer[0] = time;
		answer[1] = zero;
		return answer;
	}

}
