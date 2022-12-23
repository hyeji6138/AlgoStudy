package level1;

public class Solution_크기가작은부분문자열 {
	public static void main(String[] args) {
		String t = "3141592";
		String p = "271";
		System.out.println(solution(t, p));
	}

	public static int solution(String t, String p) {
		int answer = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < p.length(); i++) {
			sb.append(t.charAt(i));
		}
		long num = Long.parseLong(p);
		if (Long.parseLong(sb.toString()) <= num) {
			answer++;
		}
		for (int i = p.length(); i < t.length(); i++) {
			sb.append(t.charAt(i));
			sb.deleteCharAt(0);
			if (Long.parseLong(sb.toString()) <= num) {
				answer++;
			}
		}
		return answer;
	}

}
