package level0;

public class Solution_접두사인지확인하기 {
	public static void main(String[] args) {
		String my_string = "banana";
		String is_prefix = "nan";
		System.out.println(solution(my_string, is_prefix));
	}

	public static int solution(String my_string, String is_prefix) {
		int answer = answer = my_string.indexOf(is_prefix) == 0 ? 1 : 0;
		return answer;
	}

}
