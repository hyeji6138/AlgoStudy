package level0;

public class Solution_삼각형의완성조건2 {
	public static void main(String[] args) {
		int[] sides = { 3, 6 };
		System.out.println(solution(sides));
	}

	public static int solution(int[] sides) {
		int answer = 0;
		int max = Math.max(sides[0], sides[1]);
		int min = Math.min(sides[0], sides[1]);
		int side = 1;
		while (side <= max) {
			if (side + min > max) {
				answer++;
			}
			side++;
		}
		while (min + max > side) {
			answer++;
			side++;
		}
		return answer;
	}

}
