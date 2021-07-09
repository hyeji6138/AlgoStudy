package level2;

public class Solution_괄호변환 {
	public static void main(String[] args) {
		System.out.println(solution("()((()))()())()("));
	}

	public static String solution(String p) {
		String answer = "";
		boolean open = false, close = false;
		int openCnt = 0, closeCnt = 0;
		if (p.length() > 0) {
			int std = 0;
			boolean check = true;
			
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == '(') {
					open = true;
					openCnt++;
				} else {
					if (openCnt <= 0) check = false;
					close = true;
					closeCnt++;
				}

				if ((open && close) && (openCnt == closeCnt)) {
					std = i;
					break;
				}
			}
			System.out.println(check+" "+p.substring(0, std + 1));
			if (check) {
				answer = p.substring(0, std + 1);
			} else {
				StringBuffer sb = new StringBuffer();
				String temp = p.substring(1, std);
				sb.append('(');
				for (int i = 0; i < temp.length(); i++) {
					if (temp.charAt(i) == '(') sb.append(')');
					else sb.append('(');
				}
				sb.append(')');
				answer = sb.toString();
			}

			answer = answer + solution(p.substring(std + 1));
		}
		return answer;
	}
}
