package level0;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_옹알이1 {
	public static void main(String[] args) {
		String[] babbling = { "aya", "yee", "u", "maa", "wyeoo" };
		System.out.println(solution(babbling));
	}

	static public int solution(String[] babbling) {
		int answer = 0;
		HashSet<String> hash = new HashSet<String>(Arrays.asList("aya", "ye", "woo", "ma"));
		for (int i = 0; i < babbling.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < babbling[i].length(); j++) {
				sb.append(babbling[i].charAt(j));
				if (hash.contains(sb.toString())) {
					sb.setLength(0);
				}
			}
			if (sb.length() == 0 || hash.contains(sb.toString())) {
				answer += 1;
			}
		}
		return answer;
	}

}
