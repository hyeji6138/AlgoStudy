package level2;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_할인행사 {
	public static void main(String[] args) {
		String[] want = { "banana", "apple", "rice", "pork", "pot" };
		int[] number = { 3, 2, 2, 2, 1 };
		String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };
		System.out.println(solution(want, number, discount));
	}

	public static int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			hashMap.put(want[i], i);
		}
		int[] cnt = new int[number.length];
		int start = 0, end = 9;
		for (int i = start; i <= end; i++) {
			if (hashMap.containsKey(discount[i])) {
				cnt[hashMap.get(discount[i])]++;
			}
		}
		while (end < discount.length) {
			if (isPossible(number, cnt)) {
				answer++;
			}
//			System.out.println("***************");
			if (hashMap.containsKey(discount[start])) {
				cnt[hashMap.get(discount[start])]--;
			}
			start++;
			if (end + 1 < discount.length && hashMap.containsKey(discount[end + 1])) {
				cnt[hashMap.get(discount[end + 1])]++;
			}
			end++;
		}

		return answer;
	}

	public static boolean isPossible(int[] number, int[] cnt) {
//		System.out.println(Arrays.toString(number));
//		System.out.println(Arrays.toString(cnt));
		for (int i = 0; i < number.length; i++) {
			if (number[i] > cnt[i]) {
				return false;
			}
		}
		return true;
	}

}
