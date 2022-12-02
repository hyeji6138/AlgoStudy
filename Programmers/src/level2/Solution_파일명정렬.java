package level2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_파일명정렬 {
	public static void main(String[] args) {
		String[] files = { "O00321", "O49qcGPHuRLR5FEfoO00321" };
		System.out.println(Arrays.toString(solution(files)));
	}

	public static String[] solution(String[] files) {
		String[] answer = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			answer[i] = files[i];
		}
		Arrays.sort(answer, new MyComparator());
		return answer;
	}

	static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			String[] file1 = splitFileName(o1);
			String[] file2 = splitFileName(o2);

			if (file1[0].toUpperCase().equals(file2[0].toUpperCase())) {
				return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]);
			}
			return file1[0].toUpperCase().compareTo(file2[0].toUpperCase());
		}

		public String[] splitFileName(String s) {
			String[] result = new String[2];
			for (int i = 0; i < 2; i++) {
				result[i] = "";
			}
			int idx = 0;
			boolean head = true;
			for (int i = 0; i < s.length(); i++) {
				if (head && !Character.isDigit(s.charAt(i))) {
					idx = 0;
				} else if (Character.isDigit(s.charAt(i))) {
					idx = 1;
					head = false;
				} else if (!head) {
					break;
				}
				result[idx] += s.charAt(i);
			}
			System.out.println(Arrays.toString(result));
			return result;
		}

	}

}
