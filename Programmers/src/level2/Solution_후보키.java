package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution_후보키 {
//	static int[] keys;
	static HashSet<List<Integer>> hash;
	static int answer;
	static List<Integer> keys;

	public static void main(String[] args) {
//		String[][] relation = { { "100", "ryan", "music", "2", "1", "ryan", "music", "2" },
//				{ "200", "apeach", "math", "2", "2", "ryan", "music", "2" },
//				{ "300", "tube", "computer", "3", "3", "ryan", "music", "2" },
//				{ "400", "con", "computer", "4", "4", "ryan", "music", "2" },
//				{ "500", "muzi", "music", "3", "5", "ryan", "music", "2" },
//				{ "600", "apeach", "music", "2", "6", "ryan", "music", "4" } };
		String[][] relation = { { "aa", "a" }, { "a", "aa" }, { "a", "a" } };
		System.out.println(solution(relation));
	}

	public static int solution(String[][] relation) {
		int attrCnt = relation[0].length;
		answer = 0;
		hash = new HashSet<>();
		keys = new ArrayList<>();
		for (int keyCnt = 1; keyCnt <= attrCnt; keyCnt++) {
			comb(0, 0, keyCnt, attrCnt, relation);
			keys.clear();

		}
		return answer;
	}

	public static void comb(int cnt, int cur, int keyCnt, int n, String[][] relation) {
		if (cnt == keyCnt) {
			if (findKey(relation)) {
				for (int i = 0; i < keys.size(); i++) {
					System.out.print(keys.get(i) + " ");
				}
				System.out.println();
				answer++;
				hash.add(new ArrayList<Integer>(keys));
			}
			return;
		}

		for (int i = cur; i < n; i++) {
			keys.add(i);
			if (candidate()) {
				comb(cnt + 1, i + 1, keyCnt, n, relation);
			}
			keys.remove(cnt);
		}
	}

	public static boolean findKey(String[][] relation) {
		boolean result = true;
		HashSet<String> tuples = new HashSet<>();
		for (int i = 0; i < relation.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < keys.size(); j++) {
				sb.append(relation[i][keys.get(j)] + " ");
			}
			if (!tuples.contains(sb.toString())) {
				tuples.add(sb.toString());
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	public static boolean candidate() {
		boolean result = true;
		for (List<Integer> x : hash) {
			if (keys.containsAll(x)) {
				result = false;
				break;
			}
		}
		return result;
	}

}
