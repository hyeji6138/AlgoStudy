package level0;

import java.util.Arrays;

public class Solution_삼각형의완성조건1 {
	public static void main(String[] args) {
		int[] sides = { 1, 2, 3 };
		System.out.println(solution(sides));
	}

	public static int solution(int[] sides) {
		int answer = 2;
		Arrays.sort(sides);
		if (sides[2] < sides[0] + sides[1]) {
			answer = 1;
		}
		return answer;
	}

}
