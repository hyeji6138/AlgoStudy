package level2;

public class Solution_마법의엘리베이터 {
	public static void main(String[] args) {
		int storey = 175;
		System.out.println(solution(storey));
	}

	public static int solution(int storey) {
		int answer = 0;
		int num = storey;
		while (num > 0) {
//			System.out.println(num+" "+answer);
			if ((num % 10) > 10 - (num % 10) || (num % 10 == 5 && num % 100 > 50)) {
				answer += 10 - (num % 10);
				num = (num + 10) / 10;
			} else {
				answer += num % 10;
				num /= 10;
			}
		}
		return answer;
	}
}
