package level2;

public class Solution_다음큰숫자 {
	public static void main(String[] args) {
		int n = 325468;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		String nBinary = Integer.toBinaryString(n);
		int nCnt = countOne(nBinary);
		int next = n + 1;
		while (true) {
			if (nCnt == countOne(Integer.toBinaryString(next))) {
				answer = next;
				break;
			}
			next++;
		}
		return answer;
	}

	public static int countOne(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				cnt++;
			}
		}
		return cnt;
	}
}
