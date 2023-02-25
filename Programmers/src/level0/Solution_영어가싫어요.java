package level0;

public class Solution_영어가싫어요 {
	public static void main(String[] args) {
		String numbers = "onetwothreefourfivesixseveneightnine";
		System.out.println(solution(numbers));
	}

	public static long solution(String numbers) {
		long answer = 0;
		String[] alpha = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] digit = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		for (int i = 0; i < digit.length; i++) {
			numbers = numbers.replace(alpha[i], digit[i]);
		}
		answer = Long.parseLong(numbers);
		return answer;
	}
}
