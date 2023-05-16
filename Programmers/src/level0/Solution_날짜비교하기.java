package level0;

public class Solution_날짜비교하기 {
	public static void main(String[] args) {
		int[] date1 = { 2021, 1, 29 };
		int[] date2 = { 2021, 12, 29 };
		System.out.println(solution(date1, date2));
	}

	public static int solution(int[] date1, int[] date2) {
		int answer = 0;
		StringBuffer d1 = new StringBuffer();
		StringBuffer d2 = new StringBuffer();
		for (int i = 0; i < date1.length; i++) {
			d1.append(date1[i]);
			d2.append(date2[i]);
		}
		answer = Integer.parseInt(d1.toString()) < Integer.parseInt(d2.toString()) ? 1 : 0;
		return answer;
	}

}
