package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_특이한정렬 {
	public static void main(String[] args) {
		int[] numlist = { 1, 2, 3, 4, 5, 6 };
		int n = 4;
		System.out.println(Arrays.toString(solution(numlist, n)));
	}

	public static int[] solution(int[] numlist, int n) {
		int[] answer = new int[numlist.length];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numlist.length; i++) {
			list.add(numlist[i]);
		}
		Collections.sort(list, new MyComparator(n));
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	static class MyComparator implements Comparator<Integer> {
		int n;

		public MyComparator(int n) {
			this.n = n;
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if (Math.abs(this.n - o1) < Math.abs(this.n - o2)) {
				return -1;
			} else if (Math.abs(this.n - o1) == Math.abs(this.n - o2)) {
				return o2 - o1;
			} else {
				return 1;
			}
		}

	}

}
