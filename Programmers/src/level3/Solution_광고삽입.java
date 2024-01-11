package level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_광고삽입 {
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
				"01:37:44-02:02:30" };

		System.out.println(solution(play_time, adv_time, logs));

	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		int playTime = strTimeToIntTime(play_time);
		int advTime = strTimeToIntTime(adv_time);
		int[][] log_time = new int[logs.length][2];
		int[] maxPlayTime = new int[logs.length];
		for (int i = 0; i < logs.length; i++) {
			String[] log = logs[i].split("-");
			log_time[i][0] = strTimeToIntTime(log[0]);
			log_time[i][1] = strTimeToIntTime(log[1]);
		}
		Arrays.sort(log_time, new MyArraySort());
		int point = -1;
		for (int i = 0; i < log_time.length; i++) {
			maxPlayTime[i] = Math.min(log_time[i][0] + advTime, log_time[i][1] - log_time[i][0]);
			if (point < 0) {
				point = log_time[i][1];
			} else {
				if (log_time[i][0] < point) { // 이전 시청자와 겹치는 구간 있음
				} else {

				}
			}

		}
		return answer;
	}

	public static int strTimeToIntTime(String time) {
		String[] times = time.split(":");
		int result = 0;
		result += Integer.parseInt(times[0]) * 60 * 60;
		result += Integer.parseInt(times[1]) * 60;
		result += Integer.parseInt(times[2]);
		return result;
	}

	public static String intTimeToStrTime(int time) {
		StringBuffer st = new StringBuffer();
		for (int i = 0; i < 2; i++) {
			if (time % 60 < 10) {
				st.insert(0, ":0" + time % 60);
			} else {
				st.insert(0, ":" + time % 60);
			}
			time /= 60;
		}
		if (time < 10) {
			st.insert(0, "0" + time);
		} else {
			st.insert(0, "" + time);
		}
		return st.toString();
	}

	static class MyArraySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}

	static class MyQueueSort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o2[0] - o1[0];
		}

	}

}
