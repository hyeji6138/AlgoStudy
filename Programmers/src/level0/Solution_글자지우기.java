package level0;

public class Solution_글자지우기 {
	public static void main(String[] args) {
		String my_string = "apporoograpemmemprs";
		int[] indices = { 1, 16, 6, 15, 0, 10, 11, 3 };
		System.out.println(solution(my_string, indices));
	}

	public static String solution(String my_string, int[] indices) {
		String answer = "";
		String[] spl = my_string.split("");
		for (int i = 0; i < indices.length; i++) {
			spl[indices[i]] = "";
		}
		answer = String.join("", spl);
		return answer;
	}

}
