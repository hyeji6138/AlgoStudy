package level1;

import java.util.HashMap;

public class Solution_2016년 {
	public static void main(String[] args) {
		System.out.println(solution(2, 28));
	}

	public static String solution(int a, int b) {
		String answer = "";
		HashMap<Integer, String> hash = new HashMap<Integer, String>() {
			{
				put(1, "FRI");
				put(2, "SAT");
				put(3, "SUN");
				put(4, "MON");
				put(5, "TUE");
				put(6, "WED");
				put(0, "THU");
			}
		};
		int day = 0;
		for (int i = 1; i < a; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) day += 31;
			else if (i == 2) day += 29;
			else day += 30;
		}
		day += b;
		answer = hash.get(day % 7);

		return answer;
	}

}
