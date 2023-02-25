package level0;

public class Solution_문자열계산하기 {
	public static void main(String[] args) {
		String my_string = "3 + 4 - 10 + 9";
		System.out.println(solution(my_string));
	}

	public static int solution(String my_string) {
		String[] elements = my_string.split(" ");
		int answer = Integer.parseInt(elements[0]);
		for (int i = 2; i < elements.length; i += 2) {
			if (elements[i - 1].equals("+")) {
				answer += Integer.parseInt(elements[i]);
			} else {
				answer -= Integer.parseInt(elements[i]);
			}
		}

		return answer;
	}

}
