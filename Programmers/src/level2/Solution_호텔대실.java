package level2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_호텔대실 {
	public static void main(String[] args) {
		String[][] book_time = { { "15:00", "17:00" }, { "16:40", "18:20" }, { "14:20", "15:20" }, { "14:10", "19:20" },
				{ "18:20", "21:20" } };
		System.out.println(solution(book_time));
	}

	public static int solution(String[][] book_time) {
		int answer = 0;
		int[][] room = new int[book_time.length][2];
		Arrays.sort(book_time, new MyComparator());
		room[0][0] = timeToInt(book_time[0][0]);
		room[0][1] = timeToInt(book_time[0][1]);
		answer = 1;
		for (int i = 1; i < book_time.length; i++) {
			boolean newRoom = true;
			for (int j = 0; j < answer; j++) {
				if (room[j][1] + 10 <= timeToInt(book_time[i][0])) {
					room[j][0] = timeToInt(book_time[i][0]);
					room[j][1] = timeToInt(book_time[i][1]);
					newRoom = false;
					break;
				}
			}
			if (newRoom) {
				room[answer][0] = timeToInt(book_time[i][0]);
				room[answer][1] = timeToInt(book_time[i][1]);
				answer++;
			}
		}
		return answer;
	}

	public static void printArray(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class MyComparator implements Comparator<String[]> {

		@Override
		public int compare(String[] o1, String[] o2) {
			// TODO Auto-generated method stub
			if (o1[0].equals(o2[0])) {
				return timeToInt(o1[1]) - timeToInt(o2[1]);
			}
			return timeToInt(o1[0]) - timeToInt(o2[0]);
		}

	}

	public static int timeToInt(String time) {
		String[] spl = time.split(":");
		return Integer.parseInt(spl[0]) * 60 + Integer.parseInt(spl[1]);
	}

}
