package level0;

import java.util.Arrays;

public class Solution_뒤에서5등위로 {
	public static void main(String[] args) {
		int[] num_list = { 12, 4, 15, 46, 38, 1, 14, 56, 32, 10 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	public static int[] solution(int[] num_list) {
		int[] answer = new int[num_list.length - 5];
		Arrays.sort(num_list);
		answer = Arrays.copyOfRange(num_list, 5, num_list.length);
		return answer;
	}

}
