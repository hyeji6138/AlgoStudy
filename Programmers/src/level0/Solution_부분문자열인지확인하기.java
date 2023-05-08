package level0;

public class Solution_부분문자열인지확인하기 {
	public static void main(String[] args) {
		String my_string = "aa";
		String target = "aa";
		System.out.println(solution(my_string, target));
	}

	public static int solution(String my_string, String target) {
		int answer = my_string.indexOf(target) >= 0 ? 1 : 0;
		return answer;
	}

}
