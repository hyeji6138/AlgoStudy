package level1;

public class Solution_콜라츠추측 {
	public static void main(String[] args) {
		System.out.println(solution(6));
	}

	public static int solution(int num) {
		int answer = 0;
		long n = (long) num;
		while (true) {
			if (n == 1 || answer > 500) break;

			if (n % 2 == 0) n /= 2;
			else n = n * 3 + 1;
			answer++;
		}
		if(answer > 500) answer = -1;
		return answer;
	}
}
