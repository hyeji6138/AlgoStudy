package level0;

public class Solution_문자열밀기 {
	public static void main(String[] args) {
		String A = "hello";
		String B = "ohell";
		System.out.println(solution(A, B));
	}

	public static int solution(String A, String B) {
		int answer = 0;
		char[] array = A.toCharArray();
		boolean check = false;
		for (int i = 0; i < A.length(); i++) {
			System.out.println(String.valueOf(array));
			if (String.valueOf(array).equals(B)) {
				check = true;
				break;
			}
			rightShift(array);
			answer++;
		}
		if (!check) {
			answer = -1;
		}
		return answer;
	}

	public static void rightShift(char[] array) {
		char temp = array[0], pre = array[0];
		for (int i = 1; i < array.length; i++) {
			temp = array[i];
			array[i] = pre;
			pre = temp;

		}
		array[0] = pre;
	}

}
