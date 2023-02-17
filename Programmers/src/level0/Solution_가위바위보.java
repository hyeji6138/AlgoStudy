package level0;

public class Solution_가위바위보 {
	public static void main(String[] args) {
		String rsp = "205";
		System.out.println(solution(rsp));
	}

	public static String solution(String rsp) {
		String answer = "";
		for (int i = 0; i < rsp.length(); i++) {
			char x = rsp.charAt(i);
			if (x == '0') {
				answer += "5";
			} else if (x == '2') {
				answer += "0";
			} else {
				answer += "2";
			}
		}
		return answer;
	}

}
