package level3;

import java.util.HashSet;

public class Solution_불량사용자 {
	static int answer;
	static HashSet<HashSet<String>> cases;

	public static void main(String[] args) {
		String[] user_id = { "12345", "12453", "aaaaa" };
		String[] banned_id = { "*****", "*****" };
		System.out.println(solution(user_id, banned_id));
	}

	static public int solution(String[] user_id, String[] banned_id) {
		answer = 0;
		cases = new HashSet<HashSet<String>>();
		HashSet<String> hash = new HashSet<String>();
		findUser(0, user_id, banned_id, hash);
		return answer;
	}

	static public void findUser(int cnt, String[] user_id, String[] banned_id, HashSet<String> hash) {
		if (cnt == banned_id.length) {
			if (!cases.contains(hash)) {
				cases.add(new HashSet<String>(hash));
				answer += 1;
			}
			return;
		}

		String reg = banned_id[cnt].replace("*", ".");
		for (int i = 0; i < user_id.length; i++) {
			if (user_id[i].matches(reg) && !hash.contains(user_id[i])) {
				hash.add(user_id[i]);
				findUser(cnt + 1, user_id, banned_id, hash);
				hash.remove(user_id[i]);
			}
		}
	}

}
