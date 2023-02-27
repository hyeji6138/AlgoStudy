package level0;

public class Solution_종이자르기 {
	public static void main(String[] args) {
		int M = 1, N = 1;
		System.out.println(solution(M, N));
	}

	public static int solution(int M, int N) {
		int answer = 0;
		answer = (M - 1) + M * (N - 1);
		return answer;
	}

}
