package level0;

public class Solution_외계어사전 {
	public static void main(String[] args) {
		String[] spell = { "z", "d", "x" };
		String[] dic = { "def", "dww", "dzx", "loveaw" };
		System.out.println(solution(spell, dic));
	}

	public static int solution(String[] spell, String[] dic) {
		int answer = 2;
		int[] idx = new int[spell.length];
		for (int i = 0; i < idx.length; i++) {
			idx[i] = spell[i].charAt(0) - 'a';
		}
		for (int i = 0; i < dic.length; i++) {
			int[] cnt = new int[26];
			for (int j = 0; j < dic[i].length(); j++) {
				cnt[dic[i].charAt(j) - 'a']++;
			}
			boolean check = true;
			for (int j = 0; j < idx.length; j++) {
				if (cnt[idx[j]] != 1) {
					check = false;
					break;
				}
			}
			if (check) {
				answer = 1;
				break;
			}
		}

		return answer;
	}

}
