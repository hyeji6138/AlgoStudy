package level2;

import java.util.Arrays;

public class Solution_카펫 {
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int tiles = brown + yellow;
		int x = 0, y = 0;
		for (int i = 1; i <= (int) Math.sqrt(tiles); i++) {
			if (tiles % i == 0) {
				x = i;
				y = tiles / i;
				if ((x - 2) * (y - 2) == yellow) {
					break;
				}
			}
		}
		answer[0] = y;
		answer[1] = x;
		return answer;
	}

}
