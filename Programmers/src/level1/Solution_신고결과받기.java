package level1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_신고결과받기 {
	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		boolean[][] userReport = new boolean[id_list.length][id_list.length];
		int[] reportCnt = new int[id_list.length];
		HashMap<String, Integer> users = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			users.put(id_list[i], i);
		}
		for (int i = 0; i < report.length; i++) {
			String[] user = report[i].split(" ");
			if (!userReport[users.get(user[0])][users.get(user[1])]) {
				userReport[users.get(user[0])][users.get(user[1])] = true;
				reportCnt[users.get(user[1])]++;
			}
		}

		for (int i = 0; i < id_list.length; i++) {
			if (reportCnt[i] >= k) { // 신고 접수 완료
				for (int j = 0; j < id_list.length; j++) {
					if (userReport[j][i]) {
						answer[j]++;
					}
				}
			}
		}

		return answer;
	}
}
