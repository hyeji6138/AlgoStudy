package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_압축 {
	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";
		System.out.println(Arrays.toString(solution(msg)));
	}

	public static int[] solution(String msg) {
		List<Integer> list = new ArrayList<>();
		HashMap<String, Integer> dict = new HashMap<>();
		int num = 1;
		for (int i = 0; i < 26; i++) {
			StringBuffer key = new StringBuffer();
			key.append((char) ('A' + i));
			dict.put(key.toString(), num++);
		}
		for (int i = 0; i < msg.length();) {
			int idx = i + 1;
			while (idx <= msg.length()) {
				if (!dict.containsKey(msg.substring(i, idx))) {
					dict.put(msg.substring(i, idx), num++);
					break;
				}
				idx++;
			}
			list.add(dict.get(msg.subSequence(i, idx - 1)));
			i = idx - 1;
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
