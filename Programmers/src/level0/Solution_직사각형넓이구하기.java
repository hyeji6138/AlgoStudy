package level0;

public class Solution_직사각형넓이구하기 {
	public static void main(String[] args) {
		int[][] dots = { { 1, 1 }, { 2, 1 }, { 2, 2 }, { 1, 2 } };
		System.out.println(solution(dots));
	}

	public static int solution(int[][] dots) {
		int answer = 0;
		int[] max = { Integer.MIN_VALUE, Integer.MIN_VALUE };
		int[] min = { Integer.MAX_VALUE, Integer.MAX_VALUE };
		for (int i = 0; i < dots.length; i++) {
			for (int j = 0; j < dots[i].length; j++) {
				max[j] = Math.max(max[j], dots[i][j]);
				min[j] = Math.min(min[j], dots[i][j]);
			}
		}
		answer = (max[0] - min[0]) * (max[1] - min[1]);
		return answer;
	}

}
