package level3;

import java.util.Arrays;

public class Solution_셔틀버스 {
	public static void main(String[] args) {
		int n = 1, t = 1, m = 5;
		String[] timetable = { "09:10", "09:09", "08:00" };
		System.out.println(solution(n, t, m, timetable));
	}

	public static String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		int[][] bus = new int[n][m]; // 셔틀버스에 타는 크루 정보
		Arrays.sort(timetable);
		int i = 0, j = 0, k = 0; // i 사람 순서, j 버스 순서, k 버스에 탄 크루 수
		while (i < timetable.length && j < n) {
			if (timeToInt(timetable[i]) <= 9 * 60 + t * j) {
				if (k < m) {
					bus[j][k++] = i + 1;
					i++;
				} else {
					k = 0;
					j++;
				}
			} else {
				k = 0;
				j++;
			}
		}

		if (bus[n - 1][m - 1] == 0) { // 마지막 셔틀버스 타기
			answer = intToTime(9 * 60 + t * (n - 1));
		} else { // 마지막 셔틀버스에 탄 크루보다 1분 빠르게 도착
			answer = intToTime(timeToInt(timetable[bus[n - 1][m - 1] - 1]) - 1);
		}

		return answer;
	}

	public static int timeToInt(String time) {
		String[] spl = time.split(":");
		return Integer.parseInt(spl[0]) * 60 + Integer.parseInt(spl[1]);
	}

	public static String intToTime(int time) {
		StringBuffer sb = new StringBuffer();
		if (time / 60 >= 10) {
			sb.append(time / 60 + ":");
		} else {
			sb.append("0" + time / 60 + ":");
		}

		if (time % 60 >= 10) {
			sb.append(time % 60);
		} else {
			sb.append("0" + time % 60);
		}
		return sb.toString();
	}

}
