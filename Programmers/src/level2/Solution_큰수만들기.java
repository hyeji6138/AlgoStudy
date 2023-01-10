package level2;

public class Solution_큰수만들기 {
	public static void main(String[] args) {
		String number = "1111111119";
		int k = 9;
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		int idx = 0;
		for (int i = 0; i < number.length() - k; i++) {
			int max = 0;
			for (int j = idx; j <= i + k; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j + 1;
				}
			}
			sb.append(max);
		}
		answer = sb.toString();
		return answer;
	}

//	public static String solution(String number, int k) {
//		String answer = "";
//		StringBuffer sb = new StringBuffer();
//		int n = number.length();
//		for (int i = 0; i < number.length(); i++) {
//			int num = number.charAt(i) - '0';
//			int minIdx = 0, idx = sb.length();
//			if (n - i < n - k) {
//				minIdx = i - k;
//			}
//			for (idx = minIdx; idx < sb.length(); idx++) {
//				if (sb.charAt(idx) - '0' < num) {
//					sb.delete(idx, idx + 1);
//					break;
//				}
//			}
//			sb.insert(idx, num);
//		}
//		answer = sb.substring(0, n - k).toString();
//		return answer;
//	}

//	public static String solution(String number, int k) {
//		String answer = "";
//		StringBuffer sb = new StringBuffer();
//		int[] numbers = new int[number.length()];
//		int[] result = new int[number.length() - k];
//		for (int i = 0; i < number.length(); i++) {
//			numbers[i] = number.charAt(i) - '0';
//		}
//		for (int i = 0; i < numbers.length; i++) {
//			int minIdx = 0;
//			if (numbers.length - i < result.length) {
//				minIdx = i - k;
//			}
//
//			for (int j = minIdx; j < result.length; j++) {
//				if (result[j] < numbers[i]) {
//					result[j] = numbers[i];
//					break;
//				}
//			}
//		}
//		for (int i = 0; i < result.length; i++) {
//			sb.append(result[i]);
//		}
//		answer = sb.toString();
//		return answer;
//	}

}
