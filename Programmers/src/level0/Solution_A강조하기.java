package level0;

public class Solution_A강조하기 {
	public static void main(String[] args) {
		String my_string = "PrOgRaMmErS";
		System.out.println(solution(my_string));
	}

	public static String solution(String myString) {
		String answer = myString.toLowerCase().replace('a', 'A');
		return answer;
	}

}
