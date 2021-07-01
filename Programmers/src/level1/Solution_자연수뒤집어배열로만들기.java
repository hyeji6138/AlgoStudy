package level1;

import java.util.Arrays;

public class Solution_자연수뒤집어배열로만들기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(101)));
	}

	public static int[] solution(long n) {
		int[] answer = {};
		int size = 1;
		while (Math.pow(10, size) <= n) {
			size++;
		}
		answer = new int[size];
		for (int i = 0; i < size; i++) {
			answer[i] = (int) (n % 10);
			n /= 10;
		}
		return answer;
	}
}
