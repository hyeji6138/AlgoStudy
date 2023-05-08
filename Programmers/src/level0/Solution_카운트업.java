package level0;

import java.util.Arrays;

public class Solution_카운트업 {
	public static void main(String[] args) {
		int start = 3, end = 10;
		System.out.println(Arrays.toString(solution(start, end)));
	}

	public static int[] solution(int start, int end) {
		int[] answer = new int[end - start + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = start + i;
		}
		return answer;
	}

}
