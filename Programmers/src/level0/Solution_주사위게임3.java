package level0;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_주사위게임3 {
	public static void main(String[] args) {
		int a = 6;
		int b = 3;
		int c = 3;
		int d = 6;
		System.out.println(solution(a, b, c, d));
	}

	public static int solution(int a, int b, int c, int d) {
		int answer = 0;
		int[] dice = new int[7];
		int p, q, r, min = 7;
		;
		List<int[]> list = new ArrayList<int[]>();
		dice[a] += 1;
		dice[b] += 1;
		dice[c] += 1;
		dice[d] += 1;
		for (int i = 1; i <= 6; i++) {
			if (dice[i] == 4) {
				answer = 1111 * i;
				break;
			} else if (dice[i] > 0) {
				list.add(new int[] { i, dice[i] });
				min = Math.min(min, i);
			}
		}
		if (list.size() > 0) {
			list.sort(new MyComparator());
			if (list.size() == 2) {
				p = list.get(0)[0];
				q = list.get(1)[0];
				if (list.get(0)[1] == 3) {
					answer = (10 * p + q) * (10 * p + q);
				} else {
					answer = (p + q) * Math.abs(p - q);
				}
			} else if (list.size() == 3) {
				q = list.get(1)[0];
				r = list.get(2)[0];
				answer = q * r;
			} else {
				answer = min;
			}
		}
		return answer;
	}

	static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o2[1] - o1[1];
		}

	}

}
