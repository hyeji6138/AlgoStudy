package level0;

public class Solution_문자리스트를문자열로변환하기 {
	public static void main(String[] args) {
		String[] arr = { "a", "b", "c" };
		System.out.println(solution(arr));
	}

	public static String solution(String[] arr) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		answer = sb.toString();
		return answer;
	}
}
