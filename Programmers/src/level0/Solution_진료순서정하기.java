package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_진료순서정하기 {
	public static void main(String[] args) {
		int[] emergency = { 30, 10, 23, 6, 100 };
		System.out.println(Arrays.toString(solution(emergency)));
	}

	public static int[] solution(int[] emergency) {
		int[] answer = new int[emergency.length];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < emergency.length; i++) {
			list.add(new int[] { emergency[i], i });
		}
		Collections.sort(list, new MyCompurator());
		for (int i = 0; i < emergency.length; i++) {
			System.out.println(Arrays.toString(list.get(i)));
			answer[list.get(i)[1]] = i + 1;
		}
		return answer;
	}

	static class MyCompurator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o2[0] - o1[0];
		}

	}

}
