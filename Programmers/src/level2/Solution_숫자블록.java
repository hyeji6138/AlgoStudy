package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_숫자블록 {
	public static void main(String[] args) {
		long begin = 999999950, end = 1000000000;
		System.out.println(Arrays.toString(solution(begin, end)));
	}

	static public int[] solution(long begin, long end) {
		int[] answer = new int[(int) (end - begin + 1)];
		int cnt = 0;
		for (long n = begin; n <= end; n++) {
			answer[cnt++] = (int) divNumber(n);
		}
		return answer;
	}

	static public long divNumber(long n) {
		if (n == 1) {
			return 0;
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				list.add(i);
				if (n / i <= 10000000) {
					return n / i;
				}
			}
		}
		if (!list.isEmpty()) {
			return list.get(list.size() - 1);
		}
		return 1;
	}

}
