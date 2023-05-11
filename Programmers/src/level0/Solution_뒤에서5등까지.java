package level0;

import java.util.Arrays;

public class Solution_뒤에서5등까지 {
	public static void main(String[] args) {
		int[] num_list = { 12, 4, 15, 46, 38, 1, 14 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	public static int[] solution(int[] num_list) {
		int[] answer = new int[5];
		Arrays.sort(num_list);
		answer = Arrays.copyOf(num_list, 5);
		return answer;
	}

}
