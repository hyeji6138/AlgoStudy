package level0;

public class Solution_간단한논리연산 {
	public static void main(String[] args) {
		boolean x1 = false, x2 = true, x3 = true, x4 = true;
		System.out.println(solution(x1, x2, x3, x4));
	}

	public static boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
		boolean answer = (x1 || x2) && (x3 || x4);
		return answer;
	}

}
