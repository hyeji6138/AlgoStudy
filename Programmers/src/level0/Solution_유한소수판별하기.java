package level0;

import java.util.HashMap;

public class Solution_유한소수판별하기 {
	public static void main(String[] args) {
		int a = 7, b = 20;
		System.out.println(solution(a, b));
	}

	public static int solution(int a, int b) {
		int answer = 1;
		HashMap<Integer, Integer> cnt = new HashMap<>();
		int num = b;
		for (int i = 2; i <= num;) {
			if (num % i == 0) {
				if (cnt.containsKey(i)) {
					cnt.replace(i, cnt.get(i) + 1);
				} else {
					cnt.put(i, 1);
				}
				num /= i;
			} else {
				i++;
			}
		}
		num = a;
		for (int i = 2; i <= num;) {
			if (num % i == 0) {
				if (cnt.containsKey(i)) {
					if (cnt.get(i) == 1) {
						cnt.remove(i);
					} else {
						cnt.replace(i, cnt.get(i) - 1);
					}
				}
				num /= i;
			} else {
				i++;
			}
		}

		for (Integer i : cnt.keySet()) {
			if (i != 2 && i != 5) {
				answer = 2;
				break;
			}
		}
		return answer;
	}
}
