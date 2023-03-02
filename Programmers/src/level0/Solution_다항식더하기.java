package level0;

public class Solution_다항식더하기 {
	public static void main(String[] args) {
		String polynomial = "3x";
		System.out.println(solution(polynomial));
	}

	public static String solution(String polynomial) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		String[] elements = polynomial.split(" ");
		int[] cnt = new int[2];
		for (int i = 0; i < elements.length; i += 2) {
			if (elements[i].endsWith("x")) {
				String num = elements[i].substring(0, elements[i].length() - 1);
				if (num.length() > 0) {
					cnt[0] += Integer.parseInt(num);
				} else {
					cnt[0] += 1;
				}
			} else {
				cnt[1] += Integer.parseInt(elements[i]);
			}
		}

		if (cnt[0] > 1) {
			sb.append(cnt[0] + "x");
		} else if (cnt[0] == 1) {
			sb.append("x");
		}

		if (cnt[1] > 0) {
			if (cnt[0] > 0) {
				sb.append(" + ");
			}
			sb.append(cnt[1]);
		}
		answer = sb.toString();
		return answer;
	}

}
