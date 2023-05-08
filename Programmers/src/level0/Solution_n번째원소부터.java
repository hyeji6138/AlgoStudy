package level0;

import java.util.Arrays;

public class Solution_n번째원소부터 {
	public static void main(String[] args) {
		int[] num_list = { 2, 1, 6 };
		int n = 3;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	public static int[] solution(int[] num_list, int n) {
		int[] answer = Arrays.copyOfRange(num_list, n - 1, num_list.length);
//		int[] answer = new int[num_list.length - n + 1];
//		for (int i = 0; i < answer.length; i++) {
//			answer[i] = num_list[i + n - 1];
//		}
		return answer;
	}

}
