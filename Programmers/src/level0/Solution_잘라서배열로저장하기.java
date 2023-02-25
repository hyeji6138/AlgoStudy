package level0;

import java.util.Arrays;

public class Solution_잘라서배열로저장하기 {
	public static void main(String[] args) {
		String my_str = "abc1Addfggg4556b";
		int n = 6;
		System.out.println(Arrays.toString(solution(my_str, n)));
	}

	public static String[] solution(String my_str, int n) {
		int size = my_str.length() / n;
		if (my_str.length() % n > 0) {
			size += 1;
		}
		String[] answer = new String[size];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = my_str.substring(i * n, Math.min((i + 1) * n, my_str.length()));
		}
		return answer;
	}

}
