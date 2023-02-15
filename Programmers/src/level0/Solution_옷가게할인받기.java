package level0;

public class Solution_옷가게할인받기 {
	public static void main(String[] args) {
		int price = 150000;
		System.out.println(solution(price));
	}

	public static int solution(int price) {
		int answer = price;
		if (price >= 500000) {
			answer = (int) (price * 0.8);
		} else if (price >= 300000) {
			answer = (int) (price * 0.9);
		} else if (price >= 100000) {
			answer = (int) (price * 0.95);
		}
		return answer;
	}

}
