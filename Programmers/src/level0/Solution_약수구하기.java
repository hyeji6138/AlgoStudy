package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_약수구하기 {
	public static void main(String[] args) {
		int n = 1;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		int[] answer = {};
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				list.add(i);
				if (n / i != i) {
					list.add(n / i);
				}
			}
		}
		Collections.sort(list);
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
