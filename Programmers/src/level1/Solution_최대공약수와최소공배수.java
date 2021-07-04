package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_최대공약수와최소공배수 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(999998, 999999)));
	}

	public static long[] solution(int n, int m) {
		long[] answer = new long[2];
		List<Integer> nDiv = new ArrayList<Integer>();
		List<Integer> mDiv = new ArrayList<Integer>();

		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				nDiv.add(i);
				if (i * i != n) nDiv.add(n / i);
			}
		}
		for (int i = 1; i * i <= m; i++) {
			if (m % i == 0) {
				mDiv.add(i);
				if (i * i != m) mDiv.add(m / i);
			}
		}
		Collections.sort(nDiv);
		Collections.sort(mDiv);

		for (int i = nDiv.size() - 1, j = mDiv.size() - 1; i >= 0 && j >= 0;) {
			if (nDiv.get(i).equals(mDiv.get(j))) {
				answer[0] = nDiv.get(i);
				break;
			} else if (nDiv.get(i) > mDiv.get(j)) {
				i--;
			} else {
				j--;
			}
		}

		answer[1] = ((long) n * (long) m) / answer[0];

		return answer;
	}
}
