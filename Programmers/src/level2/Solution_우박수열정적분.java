package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_우박수열정적분 {
	public static void main(String[] args) {
		int k = 5;
		int[][] ranges = { { 0, 0 }, { 0, -1 }, { 2, -3 }, { 3, -3 } };
		System.out.println(Arrays.toString(solution(k, ranges)));
	}

	public static double[] solution(int k, int[][] ranges) {
		double[] answer = new double[ranges.length];
		List<Integer> num = new ArrayList<Integer>();
		while (k >= 1) {
			num.add(k);
			if (k == 1) {
				break;
			} else if (k % 2 == 0) {
				k /= 2;
			} else {
				k = k * 3 + 1;
			}
		}
		double[] area = new double[num.size()];
		for (int i = 1; i < num.size(); i++) {
			double max = Math.max(num.get(i), num.get(i - 1));
			double min = Math.min(num.get(i), num.get(i - 1));
			area[i] = min + (max - min) / 2 + area[i - 1];
		}

		for (int i = 0; i < ranges.length; i++) {
			if (ranges[i][0] == 0 && ranges[i][1] == 0) {
				answer[i] = area[area.length - 1];
			} else {
				if (ranges[i][0] > (num.size() - 1) + ranges[i][1]) {
					answer[i] = -1;
				} else {
					answer[i] = area[(num.size() - 1) + ranges[i][1]] - area[ranges[i][0]];
				}
			}
		}
		return answer;
	}

}
