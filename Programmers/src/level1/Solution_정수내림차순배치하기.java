package level1;

import java.util.Arrays;

public class Solution_정수내림차순배치하기 {
	public static void main(String[] args) {
		System.out.println(solution(118372));
	}

	public static long solution(long n) {
		long answer = 0;
		int size = 1;
		while (Math.pow(10, size) <= n) {
			size++;
		}
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = (int) (n % 10);
			n /= 10;
		}
		Arrays.sort(nums);
		for (int i = 0; i < size; i++) {
			answer += Math.pow(10, i) * nums[i];
		}
		return answer;
	}
}
