package level0;

import java.util.Arrays;

public class Solution_순서바꾸기 {
	public static void main(String[] args) {
		int[] num_list = { 2, 1, 6 };
		int n = 1;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	public static int[] solution(int[] num_list, int n) {
		int[] answer = new int[num_list.length];
		for (int i = n; i < num_list.length; i++) {
			answer[i - n] = num_list[i];
		}
		for (int i = 0; i < n; i++) {
			answer[num_list.length - n + i] = num_list[i];
		}
		return answer;
	}

}
