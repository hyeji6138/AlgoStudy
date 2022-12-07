package level2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_가장큰수 {
	public static void main(String[] args) {
		int[] numbers = { 0, 0, 0, 0 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		Integer[] arr = new Integer[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = numbers[i];
		}
		Arrays.sort(arr, new MyComparator());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && sb.charAt(0) == '0') break;
			sb.append(arr[i]);
		}
		answer = sb.toString();
		return answer;
	}

	static class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = Integer.toString(o1);
			String s2 = Integer.toString(o2);
			return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
//			for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
//				if (s1.charAt(i) == s2.charAt(i))
//					continue;
//				return s2.charAt(i) - s1.charAt(i);
//			}
//			return s2.length() - s1.length();
		}

	}

}
