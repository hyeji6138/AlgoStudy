package level1;

import java.util.HashMap;

public class Solution_옹알이2 {
	static HashMap<String, Integer> hashMap;

	public static void main(String[] args) {
		String[] babbling = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
		System.out.println(solution(babbling));
	}

	public static int solution(String[] babbling) {
		int answer = 0;
		String[] words = { "aya", "ye", "woo", "ma" };
		hashMap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			hashMap.put(words[i], i);
		}
		for (int i = 0; i < babbling.length; i++) {
			if (check(babbling[i])) {
				answer++;
			}
		}
		return answer;
	}

	public static boolean check(String s) {
		boolean result = true;
		StringBuffer sb = new StringBuffer();
		int prev = -1;
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (sb.length() > 3) {
				result = false;
				break;
			} else {
				if (hashMap.containsKey(sb.toString())) {
					if (prev == hashMap.get(sb.toString())) {
						result = false;
						break;
					} else {
						prev = hashMap.get(sb.toString());
						sb.setLength(0);
					}
				}
			}
		}
		if (sb.length() > 0 && !hashMap.containsKey(sb.toString())) {
			result = false;
		}
		return result;
	}

}
