package level0;

public class Solution_피자나눠먹기3 {
	public static void main(String[] args) {
		int slice = 7, n = 10;
		System.out.println(solution(slice, n));
	}

	public static int solution(int slice, int n) {
		int answer = 0;
		answer = n / slice;
		if (n % slice != 0) {
			answer += 1;
		}
		return answer;
	}

}
