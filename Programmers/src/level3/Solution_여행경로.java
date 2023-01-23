package level3;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution_여행경로 {
	static HashMap<String, Integer> hashEng;
	static HashMap<Integer, String> hashNum;
	static List<String> result;

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" },
				{ "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
		System.out.println(Arrays.toString(solution(tickets)));
	}

	public static String[] solution(String[][] tickets) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < tickets.length; i++) {
			for (int j = 0; j < tickets[i].length; j++) {
				if (!list.contains(tickets[i][j])) {
					list.add(tickets[i][j]);
				}
			}
		}
		Collections.sort(list);
		hashEng = new HashMap<String, Integer>();
		hashNum = new HashMap<Integer, String>();
		result = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			hashEng.put(list.get(i), i);
			hashNum.put(i, list.get(i));
		}
		int[][] ticket = new int[hashNum.size()][hashNum.size()];
		int cnt = 0;
		for (int i = 0; i < tickets.length; i++) {
			ticket[hashEng.get(tickets[i][0])][hashEng.get(tickets[i][1])] += 1;
			cnt += 1;
		}

		go(hashEng.get("ICN"), ticket, cnt);

		String[] answer = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

	public static boolean go(int x, int[][] ticket, int cnt) {
		boolean answer = false;
		if (cnt <= 0) {
			answer = true;
		} else {
			for (int i = 0; i < hashNum.size(); i++) {
				if (ticket[x][i] > 0) {
					ticket[x][i] -= 1;
					answer = go(i, ticket, cnt - 1);
					if (!answer) {
						ticket[x][i] += 1;
					} else {
						break;
					}
				}
			}
		}

		if (answer) {
			result.add(0, hashNum.get(x));
		}

		return answer;
	}

	public static boolean check(int[][] ticket) {
		for (int i = 0; i < ticket.length; i++) {
			for (int j = 0; j < ticket[i].length; j++) {
				if (ticket[i][j] > 0) {
					return false;
				}
			}
		}
		return true;
	}

}
