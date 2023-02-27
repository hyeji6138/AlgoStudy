package level0;

public class Solution_치킨쿠폰 {
	public static void main(String[] args) {
		int chicken = 100;
		System.out.println(solution(chicken));
	}

	public static int solution(int chicken) {
		int answer = 0;
		while (chicken >= 10) {
			answer += chicken / 10;
			chicken = chicken / 10 + chicken % 10;
		}
		return answer;
	}

}
