package level2;

import java.util.HashMap;

public class Solution_단체사진찍기 {
	public static void main(String[] args) {
		String[] data = { "M~C<2", "C~M>1" }; // "N~F=0", "R~T>2"
		int n = 2;
		System.out.println(solution(n, data));
	}

	public static int solution(int n, String[] data) {
		int answer = 0;
		HashMap<Character, Integer> friend = new HashMap<Character, Integer>() {
			{
				put('A', 0);
				put('C', 1);
				put('F', 2);
				put('J', 3);
				put('M', 4);
				put('N', 5);
				put('R', 6);
				put('T', 7);
			}
		};
		int[] line = new int[friend.size()];
		boolean[] select = new boolean[friend.size()];
		answer = perm(0, friend, line, select, data);
		return answer;
	}

	public static int perm(int cnt, HashMap<Character, Integer> friend, int[] line, boolean[] select, String[] data) {
		if (cnt == 8) {
			for (int i = 0; i < data.length; i++) {
				char s = data[i].charAt(0);
				char e = data[i].charAt(2);
				char sign = data[i].charAt(3);
				int dist = data[i].charAt(4)-'0';

				int len = Math.abs(line[friend.get(s)] - line[friend.get(e)]) - 1;
				if ((sign == '=' && dist != len) || (sign == '>' && dist >= len) || (sign == '<' && dist <= len)) {
					return 0;
				}
			}
			return 1;
		}
		int result = 0;
		for (int i = 0; i < 8; i++) {
			if (!select[i]) {
				line[cnt] = i;
				select[i] = true;
				result += perm(cnt + 1, friend, line, select, data);
				select[i] = false;
			}
		}
		return result;
	}
}
