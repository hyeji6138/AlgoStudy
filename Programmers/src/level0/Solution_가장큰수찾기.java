package level0;

import java.util.Arrays;

public class Solution_가장큰수찾기 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 8, 3 };
		System.out.println(Arrays.toString(solution(array)));
	}

	public static int[] solution(int[] array) {
		int[] answer = { 0, 0 }; // max, maxIdx
		for (int i = 0; i < array.length; i++) {
			if (answer[0] < array[i]) {
				answer[0] = array[i];
				answer[1] = i;
			}
		}
		return answer;
	}

}
