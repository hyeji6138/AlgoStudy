package level0;

public class Solution_문자열겹쳐쓰기 {
	public static void main(String[] args) {
		String my_string = "He11oWor1d";
		String overwrite_string = "lloWorl";
		int s = 2;
		System.out.println(solution(my_string, overwrite_string, s));

	}

	public static String solution(String my_string, String overwrite_string, int s) {
		String answer = "";
		String[] my_spl = my_string.split("");
		String[] over_spl = overwrite_string.split("");
		for (int i = 0; i < overwrite_string.length(); i++) {
			my_spl[s + i] = over_spl[i];
		}
		answer = String.join("", my_spl);
		return answer;
	}

}
