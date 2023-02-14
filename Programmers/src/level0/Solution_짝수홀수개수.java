package level0;

import java.util.Arrays;

public class Solution_짝수홀수개수 {
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	public static int[] solution(int[] num_list) {
		int[] answer = { 0, 0 };
		for (int i = 0; i < num_list.length; i++) {
			answer[num_list[i] % 2] += 1;
		}
		return answer;
	}

}
