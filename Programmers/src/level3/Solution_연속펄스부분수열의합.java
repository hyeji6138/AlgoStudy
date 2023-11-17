package level3;

public class Solution_연속펄스부분수열의합 {
	public static void main(String[] args) {
		int[] sequence = { 2, 3, -6, 1, 3, -1, 2, 4 };
		System.out.println(solution(sequence));
	}

	static public long solution(int[] sequence) {
		long answer = 0;
		long[] max = { Long.MIN_VALUE, Long.MIN_VALUE }; // 0은 전 값이 -1일 때, 1은 전 값이 1일 때
		for (int i = 0; i < sequence.length; i++) {
			long pos = sequence[i] * 1;
			long nega = sequence[i] * -1;
			long nextPos = max[1], nextNega = max[0];
			if (max[0] == Long.MIN_VALUE) {
				nextNega = nega;
			} else {
				nextNega = Math.max(nega, max[1] + nega);
			}

			if (max[1] == Long.MIN_VALUE) {
				nextPos = pos;
			} else {
				nextPos = Math.max(pos, max[0] + pos);
			}

			max[0] = nextNega;
			max[1] = nextPos;
			answer = Math.max(answer, Math.max(max[0], max[1]));
		}
		return answer;
	}

}
