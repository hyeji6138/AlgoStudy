package level2;

import java.util.HashSet;

public class Solution_소수찾기 {
	static boolean[] selected;
	static int[] select;
	static int answer;
	static HashSet<Integer> hash;

	public static void main(String[] args) {
		String numbers = "0234567";
		System.out.println(solution(numbers));
	}

	public static int solution(String numbers) {
		answer = 0;
		int[] num = new int[numbers.length()];
		selected = new boolean[numbers.length()];
		hash = new HashSet<>();
		for (int i = 0; i < num.length; i++) {
			num[i] = numbers.charAt(i) - '0';
		}
		for (int i = 1; i <= numbers.length(); i++) {
			select = new int[i];
			perm(0, i, num);
		}
		return answer;
	}

	public static void perm(int cnt, int num, int[] numbers) {
		if (cnt == num) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < select.length; i++) {
				sb.append(numbers[select[i]]);
			}
			int result = Integer.parseInt(sb.toString());
			if (isPrime(result) && !hash.contains(result)) {
				hash.add(result);
				System.out.println(sb.toString());
				answer++;
			}
			return;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (!selected[i]) {
				if (cnt == 0 && numbers[i] == 0) continue;
				selected[i] = true;
				select[cnt] = i;
				perm(cnt + 1, num, numbers);
				selected[i] = false;
			}
		}
	}

	public static boolean isPrime(int number) {
		if (number <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}
