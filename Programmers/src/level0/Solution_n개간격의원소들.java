package level0;

import java.util.Arrays;

public class Solution_n개간격의원소들 {
	public static void main(String[] args) {
		int[] num_list = { 4, 2, 6, 1, 7, 6 };
		int n = 4;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	public static int[] solution(int[] num_list, int n) {
		int[] answer = new int[(num_list.length - 1) / n + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = num_list[n * i];
		}
		return answer;
	}

}
