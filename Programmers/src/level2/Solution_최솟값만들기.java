package level2;

import java.util.Arrays;

public class Solution_최솟값만들기 {
	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { 3, 4 };
		System.out.println(solution(A, B));
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int min1 = 0, min2 = 0;
		for (int i = 0; i < A.length; i++) {
			min1 += A[i] * B[B.length - 1 - i];
			min2 += A[A.length - 1 - i] * B[i];
		}
		answer = Math.min(min1, min2);
		return answer;
	}

}
