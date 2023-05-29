package level1;

import java.util.Arrays;

public class Solution_바탕화면정리 {
	public static void main(String[] args) {
		String[] wallpaper = { ".#...", "..#..", "...#." };
		System.out.println(Arrays.toString(solution(wallpaper)));
	}

	public static int[] solution(String[] wallpaper) {
		int[] answer = { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0 };
		for (int i = 0; i < wallpaper.length; i++) {
			for (int j = 0; j < wallpaper[i].length(); j++) {
				if (wallpaper[i].charAt(j) == '#') {
					answer[0] = Math.min(answer[0], i);
					answer[1] = Math.min(answer[1], j);
					answer[2] = Math.max(answer[2], i + 1);
					answer[3] = Math.max(answer[3], j + 1);
				}
			}
		}
		return answer;
	}
}
