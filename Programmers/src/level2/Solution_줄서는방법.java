package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_줄서는방법 {

	public static void main(String[] args) {
		int n = 3;
		long k = 5;
		System.out.println(Arrays.toString(solution(n, k)));
	}

	public static int[] solution(int n, long k) {
		int[] answer = new int[n];
		long[] factorial = new long[n + 1];
		List<Integer> list = new ArrayList<>();
		factorial[0] = 1l;
		for (int i = 1; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
			list.add(i);
		}
		for (int i = n, j = 0; i >= 1; i--) {
			int idx = (int) ((k - 1) / factorial[i - 1]);
			answer[j++] = list.remove(idx);
			k = k % factorial[i - 1];
			if (k == 0) {
				while (j < n) {
					answer[j++] = list.remove(list.size() - 1);
				}
				break;
			}
		}
		return answer;
	}

	public static long factorial(int num) {
		long result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}

}
