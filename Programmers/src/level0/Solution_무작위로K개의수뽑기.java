package level0;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_무작위로K개의수뽑기 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 1, 1 };
		int k = 1;
		System.out.println(Arrays.toString(solution(arr, k)));
	}

	public static int[] solution(int[] arr, int k) {
		int[] answer = new int[k];
		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < answer.length; i++) {
			answer[i] = -1;
		}
		for (int i = 0, j = 0; i < arr.length && j < answer.length; i++) {
			if (!hash.contains(arr[i])) {
				answer[j++] = arr[i];
				hash.add(arr[i]);
			}
		}
		return answer;
	}

}
