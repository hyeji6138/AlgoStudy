package level0;

public class Solution_평행 {
	public static void main(String[] args) {
		int[][] dots = { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } };
		System.out.println(solution(dots));
	}

	public static int solution(int[][] dots) {
		int answer = 0;
		for (int i = 1; i < dots.length; i++) {
			double line1 = (double) (dots[0][1] - dots[i][1]) / (dots[0][0] - dots[i][0]);
			int d1 = i % 3 + 1;
			int d2 = d1 % 3 + 1;
			double line2 = (double) (dots[d1][1] - dots[d2][1]) / (dots[d1][0] - dots[d2][0]);
			if (line1 == line2) {
				answer = 1;
				break;
			}
		}

//		double line1 = (double) (dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]);
//		double line2 = (double) (dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0]);
//		if (line1 == line2) {
//			answer = 1;
//		} else {
//			line1 = (double) (dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]);
//			line2 = (double) (dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0]);
//			if (line1 == line2) {
//				answer = 1;
//			} else {
//				line1 = (double) (dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]);
//				line2 = (double) (dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0]);
//				if (line1 == line2) {
//					answer = 1;
//				}
//			}
//		}
		return answer;
	}

}
