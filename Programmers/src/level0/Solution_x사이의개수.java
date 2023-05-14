package level0;

import java.util.Arrays;

public class Solution_x사이의개수 {
	public static void main(String[] args) {
		String myString = "oxooxoxxox";
		System.out.println(Arrays.toString(solution(myString)));
	}

	public static int[] solution(String myString) {
		String[] x = myString.split("x", -1);
		int[] answer = new int[x.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = x[i].length();
		}
		return answer;
	}

}
