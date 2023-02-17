package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_n의배수고르기 {
	public static void main(String[] args) {
		int n = 3;
		int[] numlist = { 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		System.out.println(Arrays.toString(solution(n, numlist)));
	}

	public static int[] solution(int n, int[] numlist) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0) {
				list.add(numlist[i]);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
