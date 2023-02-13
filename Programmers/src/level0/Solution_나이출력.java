package level0;

public class Solution_나이출력 {
	public static void main(String[] args) {
		int age = 23;
		System.out.println(solution(age));
	}

	public static int solution(int age) {
		int answer = 0;
		answer = 2022 - age + 1;
		return answer;
	}

}
