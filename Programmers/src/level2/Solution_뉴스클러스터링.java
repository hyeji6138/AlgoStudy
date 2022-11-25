package level2;

import java.util.HashMap;

public class Solution_뉴스클러스터링 {
	public static void main(String[] args) {
		String str1 = "";
		String str2 = "";
		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		int answer = 0;
		HashMap<String, Integer> hash1 = new HashMap<>();
		HashMap<String, Integer> hash2 = new HashMap<>();

		for (int i = 0; i < str1.length() - 1; i++) {
			String s = str1.toUpperCase().substring(i, i + 2);
			if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
				if (!hash1.containsKey(s)) {
					hash1.put(s, 1);
				} else {
					int cnt = hash1.remove(s);
					hash1.put(s, cnt + 1);
				}
			}
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			String s = str2.toUpperCase().substring(i, i + 2);
			if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
				if (!hash2.containsKey(s)) {
					hash2.put(s, 1);
				} else {
					int cnt = hash2.remove(s);
					hash2.put(s, cnt + 1);
				}
			}
		}
		// 교집합 개수
		double intersection = 0, sum = 0;
		for (String key : hash1.keySet()) {
			if (hash2.containsKey(key)) {
				intersection += Math.min(hash1.get(key), hash2.get(key));
				sum += Math.max(hash1.get(key), hash2.get(key));
			} else {
				sum += hash1.get(key);
			}
		}
		for (String key : hash2.keySet()) {
			if (!hash1.containsKey(key)) {
				sum += hash2.get(key);
			}
		}
		if (sum == 0) {
			answer = (int) (1 * 65536);
		} else {
			answer = (int) (intersection / sum * 65536);
		}
		return answer;
	}

}
