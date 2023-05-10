package level0;

public class Solution_문자열바꿔서찾기 {
	public static void main(String[] args) {
		String myString = "ABBAA";
		String pat = "AABB";
		System.out.println(solution(myString, pat));
	}

	public static int solution(String myString, String pat) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < myString.length(); i++) {
			if (myString.charAt(i) == 'A') {
				sb.append('B');
			} else {
				sb.append('A');
			}
		}
		int answer = sb.toString().indexOf(pat) >= 0 ? 1 : 0;
		return answer;
	}

}
