package level0;

public class Solution_컨트롤제트 {
	public static void main(String[] args) {
		String s = "1 2 Z 3";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		String[] step = s.split(" ");
		int preNum = Integer.parseInt(step[0]);
		int answer = preNum;
		for (int i = 1; i < step.length; i++) {
			if (step[i].equals("Z")) {
				answer -= preNum;
			} else {
				preNum = Integer.parseInt(step[i]);
				answer += preNum;
			}
		}
		return answer;
	}

}
