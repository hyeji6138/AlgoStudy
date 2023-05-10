package level0;

public class Solution_rny_string {
	public static void main(String[] args) {
		String rny_string = "masterpiece";
		System.out.println(solution(rny_string));
	}

	public static String solution(String rny_string) {
		String answer = rny_string.replace("m", "rn");
		return answer;
	}

}
