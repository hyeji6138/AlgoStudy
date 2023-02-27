package level0;

public class Solution_로그인성공 {
	public static void main(String[] args) {
		String[] id_pw = { "meosseugi", "1234" };
		String[][] db = { { "rardss", "123" }, { "yyoom", "1234" }, { "meosseugi", "1234" } };
		System.out.println(solution(id_pw, db));
	}

	public static String solution(String[] id_pw, String[][] db) {
		String answer = "";
		for (int i = 0; i < db.length; i++) {
			if (db[i][0].equals(id_pw[0])) {// 아이디 있음
				if (db[i][1].equals(id_pw[1])) {// 로그인 성공
					answer = "login";
				} else {
					answer = "wrong pw";
				}
				break;
			}
		}
		if (answer.length() == 0) {
			answer = "fail";
		}
		return answer;
	}

}
