package level2;

public class Solution_스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			boolean[] skill_master = new boolean[skill.length()];
			boolean ok = true;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				int idx = skill.indexOf(skill_trees[i].charAt(j));
				if (idx >= 0) {
					if (idx == 0 || skill_master[idx - 1]) {
						skill_master[idx] = true;
					} else {
						ok = false;
						break;
					}
				}
			}
			if (ok) {
				answer++;
			}
		}

		return answer;
	}

}
