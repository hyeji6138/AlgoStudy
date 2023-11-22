package level3;

public class Solution_풍선터트리기 {
	public static void main(String[] args) {
		int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
		System.out.println(solution(a));
	}

	static public int solution(int[] a) {
		int answer = 0;
		int[] leftMin = new int[a.length];
		int[] rightMin = new int[a.length];
		leftMin[0] = a[0];
		rightMin[a.length - 1] = a[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < leftMin[i - 1]) {
				leftMin[i] = a[i];
			} else {
				leftMin[i] = leftMin[i - 1];
			}

			if (a[a.length - 1 - i] < rightMin[a.length - i]) {
				rightMin[a.length - 1 - i] = a[a.length - 1 - i];
			} else {
				rightMin[a.length - 1 - i] = rightMin[a.length - i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(leftMin[i] + " " + rightMin[i]);
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
				answer++;
			}
		}

//		boolean[] left = new boolean[a.length];
//		boolean[] right = new boolean[a.length];
//		int leftMin = a[0], rightMin = a[a.length - 1];
//		for (int i = 1; i < a.length; i++) {
//			if (a[i] >= leftMin) {
//				left[i] = true;
//			} else {
//				leftMin = a[i];
//			}
//
//			if (a[a.length - 1 - i] >= rightMin) {
//				right[a.length - 1 - i] = true;
//			} else {
//				rightMin = a[a.length - 1 - i];
//			}
//		}
//
//		for (int i = 0; i < a.length; i++) {
//			if (!left[i] || !right[i]) {
//				answer += 1;
//			}
//		}
		return answer;
	}

}
