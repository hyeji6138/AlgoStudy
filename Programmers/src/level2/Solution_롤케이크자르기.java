package level2;

public class Solution_롤케이크자르기 {
	public static void main(String[] args) {
		int[] topping = { 1, 2, 1, 3, 1, 4, 1, 2 };
		System.out.println(solution(topping));
	}

	public static int solution(int[] topping) {
		int answer = 0;
		int leftCnt = 0, rightCnt = 0;
		int[] toppingCnt = new int[10001];
		boolean[] exist = new boolean[10001];
		for (int i = 0; i < topping.length; i++) {
			if (!exist[topping[i]]) {
				exist[topping[i]] = true;
				rightCnt++;
			}
			toppingCnt[topping[i]]++;
		}
		exist = new boolean[10001];
		for (int i = 0; i < topping.length; i++) {
			if (!exist[topping[i]]) {
				exist[topping[i]] = true;
				leftCnt++;
			}
			toppingCnt[topping[i]]--;
			if (toppingCnt[topping[i]] == 0) {
				rightCnt--;
			}
			if (leftCnt == rightCnt) {
				answer++;
			}
		}
		return answer;
	}
}
