package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = { 4, 4, 4, 3, 3 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		int[] answer = {};
		List<Integer> list = new ArrayList<Integer>();
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			if (list.size() <= 0) {
				list.add(arr[i]);
				num = arr[i];
			} else {
				if (num == arr[i]) continue;
				else {
					list.add(arr[i]);
					num = arr[i];
				}
			}
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
