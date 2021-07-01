package level1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		System.out.println(Arrays.toString(solution(strings, n)));
	}

	public static String[] solution(String[] strings, int n) {
		String[] answer = {};
		Arrays.sort(strings, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) == o2.charAt(n)) {
					return o1.compareTo(o2);
				}
				return o1.charAt(n) - o2.charAt(n);
			}
			
		});
		answer = strings;
		return answer;
	}
}
