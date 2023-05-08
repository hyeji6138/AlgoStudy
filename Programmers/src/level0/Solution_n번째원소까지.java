package level0;

import java.util.Arrays;

public class Solution_n번째원소까지 {
	public static void main(String[] args) {
		int[] num_list = { 2, 1, 6 };
		int n = 1;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	public static int[] solution(int[] num_list, int n) {
		int[] answer = Arrays.copyOf(num_list, n);
		return answer;
	}

}
