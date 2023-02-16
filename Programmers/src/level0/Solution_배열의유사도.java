package level0;

import java.util.HashSet;

public class Solution_배열의유사도 {
	public static void main(String[] args) {
		String[] s1 = { "a", "b", "c" };
		String[] s2 = { "com", "b", "d", "p", "c" };
		System.out.println(solution(s1, s2));
	}

	public static int solution(String[] s1, String[] s2) {
		int answer = 0;
		HashSet<String> hash = new HashSet<String>();
		for (int i = 0; i < s1.length; i++) {
			hash.add(s1[i]);
		}
		for (int i = 0; i < s2.length; i++) {
			if (hash.contains(s2[i])) {
				answer++;
			}
		}
		return answer;
	}

}
