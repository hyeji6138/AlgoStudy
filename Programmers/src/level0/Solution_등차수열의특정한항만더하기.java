package level0;

public class Solution_등차수열의특정한항만더하기 {
	public static void main(String[] args) {
		int a = 3, d = 4;
		boolean[] included = { true, false, false, true, true };
		System.out.println(solution(a, d, included));
	}

	public static int solution(int a, int d, boolean[] included) {
		int answer = 0;
		int now = a;
		for (int i = 0; i < included.length; i++) {
			if (included[i]) {
				answer += now;
			}
			now += d;
		}
		return answer;
	}

}
