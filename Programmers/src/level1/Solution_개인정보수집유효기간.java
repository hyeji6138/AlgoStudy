package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_개인정보수집유효기간 {
	public static void main(String[] args) {
		String today = "2020.01.01";
		String[] terms = { "Z 3", "D 5" };
		String[] privacies = { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" };
		System.out.println(Arrays.toString(solution(today, terms, privacies)));
	}

	public static int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> list = new ArrayList<>();
		HashMap<String, Integer> hash = new HashMap<>();
		String[] date = today.split("\\.");
		int todayInt = Integer.parseInt(date[0]) * 12 * 28 + Integer.parseInt(date[1]) * 28 + Integer.parseInt(date[2]);
		for (int i = 0; i < terms.length; i++) {
			String[] data = terms[i].split(" ");
			hash.put(data[0], Integer.parseInt(data[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] data = privacies[i].split(" ");
			date = data[0].split("\\.");
			int dateInt = Integer.parseInt(date[0]) * 12 * 28 + Integer.parseInt(date[1]) * 28
					+ Integer.parseInt(date[2]) - 1;
			dateInt += hash.get(data[1]) * 28;

			if (dateInt < todayInt) {
				list.add(i + 1);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;

	}

//	public static int[] solution(String today, String[] terms, String[] privacies) {
//		List<Integer> list = new ArrayList<>();
//		HashMap<String, Integer> hash = new HashMap<>();
//		String[] date = today.split("\\.");
//		int t_year = Integer.parseInt(date[0]);
//		int t_month = Integer.parseInt(date[1]);
//		int t_day = Integer.parseInt(date[2]);
//
//		for (int i = 0; i < terms.length; i++) {
//			String[] data = terms[i].split(" ");
//			hash.put(data[0], Integer.parseInt(data[1]));
//		}
//
//		for (int i = 0; i < privacies.length; i++) {
//			String[] data = privacies[i].split(" ");
//			date = data[0].split("\\.");
//			int year = Integer.parseInt(date[0]);
//			int month = Integer.parseInt(date[1]);
//			int day = Integer.parseInt(date[2]);
//
//			day -= 1;
//			if (day == 0) {
//				day = 28;
//				month -= 1;
//			}
//			year += hash.get(data[1]) / 12;
//			month += hash.get(data[1]) % 12;
//			if (month > 12) {
//				month = month % 12 == 0 ? 12 : month % 12;
//				year += 1;
//			}
//
//			if (year < t_year) {
//				list.add(i + 1);
//			} else if (year == t_year) {
//				if (month < t_month) {
//					list.add(i + 1);
//				} else if (month == t_month) {
//					if (day < t_day) {
//						list.add(i + 1);
//					}
//				}
//			}
//		}
//
//		int[] answer = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			answer[i] = list.get(i);
//		}
//		return answer;
//	}

}
