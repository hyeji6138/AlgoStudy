package level1;

public class Solution_최소직사각형 {
	public static void main(String[] args) {
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		System.out.println(solution(sizes));
	}

	public static int solution(int[][] sizes) {
		int answer = 0;
		int[] wallet = { 0, 0 };
		for (int i = 0; i < sizes.length; i++) {
			int minSize = Math.min(sizes[i][0], sizes[i][1]);
			int maxSize = Math.max(sizes[i][0], sizes[i][1]);
			if (wallet[0] < minSize) {
				wallet[0] = minSize;
			}
			if (wallet[1] < maxSize) {
				wallet[1] = maxSize;
			}
		}
		answer = wallet[0] * wallet[1];
		return answer;
	}

}
