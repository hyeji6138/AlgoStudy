package level0;

public class Solution_l로만들기 {
	public static void main(String[] args) {
		String myString = "abcdevwxyz";
		System.out.println(solution(myString));
	}

	public static String solution(String myString) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < myString.length(); i++) {
			if (myString.charAt(i) < 'l') {
				sb.append('l');
			} else {
				sb.append(myString.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}

}
