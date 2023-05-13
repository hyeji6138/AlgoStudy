package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_배열의원소삭제하기 {
	public static void main(String[] args) {
		int[] arr = { 293, 1000, 395, 678, 94 };
		int[] delete_list = { 94, 777, 104, 1000, 1, 12 };
		System.out.println(Arrays.toString(solution(arr, delete_list)));
	}

	public static int[] solution(int[] arr, int[] delete_list) {
		List<Integer> delete = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < delete_list.length; i++) {
			delete.add(delete_list[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (!delete.contains(arr[i])) {
				list.add(arr[i]);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
