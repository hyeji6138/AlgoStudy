package level0;

import java.util.Arrays;

public class Solution_마지막두원소 {
	public static void main(String[] args) {
		int[] num_list = { 5, 2, 1, 7, 5 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	public static int[] solution(int[] num_list) {
		int[] answer = new int[num_list.length + 1];
		for (int i = 0; i < num_list.length; i++) {
			answer[i] = num_list[i];
		}
		if (num_list[num_list.length - 1] > num_list[num_list.length - 2]) {
			answer[answer.length - 1] = num_list[num_list.length - 1] - num_list[num_list.length - 2];
		} else {
			answer[answer.length - 1] = num_list[num_list.length - 1] * 2;
		}
		return answer;
	}

}
