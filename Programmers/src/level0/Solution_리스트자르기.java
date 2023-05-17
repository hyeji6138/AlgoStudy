package level0;

import java.util.Arrays;

public class Solution_리스트자르기 {
	public static void main(String[] args) {
		int n = 3;
		int[] slicer = { 1, 5, 2 };
		int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(solution(n, slicer, num_list)));
	}

	public static int[] solution(int n, int[] slicer, int[] num_list) {
		int[] answer = {};
		switch (n) {
		case 1:
			answer = Arrays.copyOf(num_list, slicer[1] + 1);
			break;
		case 2:
			answer = Arrays.copyOfRange(num_list, slicer[0], num_list.length);
			break;
		case 3:
			answer = Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
			break;
		case 4:
			answer = new int[(slicer[1] - slicer[0]) / 2 + 1];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = num_list[slicer[0] + i * slicer[2]];
			}
			break;
		default:
			break;
		}
		return answer;
	}

}
