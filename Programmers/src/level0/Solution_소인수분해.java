package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_소인수분해 {
	public static void main(String[] args) {
		int n = 420;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		int[] answer = {};
		List<Integer> list = new ArrayList<>();
		int num = 2;
		while (n > 0 && num <= n) {
			if (n % num == 0) {
				if (!list.contains(num)) {
					list.add(num);
				}
				n /= num;
			} else {
				num++;
			}
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
