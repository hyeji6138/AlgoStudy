package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_숫자카드나누기 {
	public static void main(String[] args) {
		int[] arrayA = { 10, 20 };
		int[] arrayB = { 5, 17 };
		System.out.println(solution(arrayA, arrayB));
	}

	public static int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		List<Integer> divA = divisor(arrayA[0]);
		List<Integer> divB = divisor(arrayB[0]);

		for (int i = 0; i < divA.size(); i++) {
			int n = divA.get(i);
			boolean check = true;
			for (int j = 0; j < arrayA.length; j++) {
				if (arrayA[j] % n != 0 || arrayB[j] % n == 0) {
					check = false;
					break;
				}
			}
			if (check) {
				answer = Math.max(answer, n);
			}
		}

		for (int i = 0; i < divB.size(); i++) {
			int n = divB.get(i);
			boolean check = true;
			for (int j = 0; j < arrayA.length; j++) {
				if (arrayB[j] % n != 0 || arrayA[j] % n == 0) {
					check = false;
					break;
				}
			}
			if (check) {
				answer = Math.max(answer, n);
			}
		}
		return answer;
	}

	public static List<Integer> divisor(int num) {
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				result.add(i);
				if (i != num / i) {
					result.add(num / i);
				}
			}
		}
		return result;
	}

}
