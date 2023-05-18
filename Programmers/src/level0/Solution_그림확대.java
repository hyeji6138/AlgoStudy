package level0;

import java.util.Arrays;

public class Solution_그림확대 {
	public static void main(String[] args) {
		String[] picture = { ".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...",
				"....x...." };
		int k = 2;
		System.out.println(Arrays.toString(solution(picture, k)));
	}

	public static String[] solution(String[] picture, int k) {
		String[] answer = new String[picture.length * k];
		for (int i = 0; i < picture.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < picture[i].length(); j++) {
				for (int s = 0; s < k; s++) {
					sb.append(picture[i].charAt(j));
				}
			}
			for (int s = 0; s < k; s++) {
				answer[k * i + s] = sb.toString();
			}
		}
		return answer;
	}

}
