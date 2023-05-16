package level0;

import java.util.HashMap;

public class Solution_문자열묶기 {
	public static void main(String[] args) {
		String[] strArr = { "a", "bc", "d", "efg", "hi" };
		System.out.println(solution(strArr));
	}

	public static int solution(String[] strArr) {
		int answer = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < strArr.length; i++) {
			int len = strArr[i].length();
			if (hashMap.containsKey(len)) {
				hashMap.replace(len, hashMap.get(len) + 1);
			} else {
				hashMap.put(len, 1);
			}

			if (hashMap.get(len) > answer) {
				answer = hashMap.get(len);
			}
		}
		return answer;
	}
}
