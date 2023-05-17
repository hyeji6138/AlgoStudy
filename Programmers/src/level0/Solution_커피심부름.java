package level0;

public class Solution_커피심부름 {
	public static void main(String[] args) {
		String[] order = { "cafelatte", "americanoice", "hotcafelatte", "anything" };
		System.out.println(solution(order));
	}

	public static int solution(String[] order) {
		int answer = 0;
		for (int i = 0; i < order.length; i++) {
			if (order[i].contains("americano")) {
				answer += 4500;
			} else if (order[i].contains("cafelatte")) {
				answer += 5000;
			} else {
				answer += 4500;
			}
		}
		return answer;
	}

}
