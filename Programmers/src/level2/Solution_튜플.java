package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Solution_튜플 {
	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		int[] answer = {};
		s = s.replaceAll("\\}.\\{", " ").replaceAll("\\{", "").replaceAll("\\}", "");
		String[] text = s.split(" ");
		List<int[]> list = new ArrayList<>();
		int maxSize = 0;
		for (int i = 0; i < text.length; i++) {
			String[] numbers = text[i].split(",");
			int[] array = new int[numbers.length];
			if (maxSize < numbers.length) {
				maxSize = numbers.length;
			}

			for (int j = 0; j < numbers.length; j++) {
				array[j] = Integer.parseInt(numbers[j]);
			}

			list.add(array);
		}
		list.sort(new MyComparator());
		answer = new int[maxSize];
		HashSet<Integer> hash = new HashSet<>();
		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] set = list.get(i);
			for (int j = 0; j < set.length; j++) {
				if (!hash.contains(set[j])) {
					hash.add(set[j]);
					answer[idx++] = set[j];
				}
			}
		}

		return answer;
	}

	public static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1.length - o2.length;
		}

	}

}
