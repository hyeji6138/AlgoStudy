package level0;

public class Solution_수조작하기1 {
	public static void main(String[] args) {
		int n = 0;
		String control = "wsdawsdassw";
		System.out.println(solution(n, control));
	}

	public static int solution(int n, String control) {
		int answer = n;
		for (int i = 0; i < control.length(); i++) {
			switch (control.charAt(i)) {
			case 'w':
				answer += 1;
				break;
			case 's':
				answer -= 1;
				break;
			case 'd':
				answer += 10;
				break;
			case 'a':
				answer -= 10;
				break;
			default:
				break;
			}
		}
		return answer;
	}

}
