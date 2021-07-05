package level2;

import java.util.Stack;

public class Solution_짝지어제거하기 {
	public static void main(String[] args) {
		System.out.println(solution("cabbaaac"));
	}

	public static int solution(String s) {
		int answer = -1;
		int preIdx = 0, idx = 1;
		int len = s.length();
		Stack<Integer> stack = new Stack<Integer>();
		while (idx < s.length()) {
			if (s.charAt(preIdx) == s.charAt(idx)) {
				len -= 2;
				if(stack.size() <= 0 && preIdx >= 1) {
					preIdx--;
					idx++;
				}else if(stack.size() > 0){
					preIdx = stack.pop();
					idx++;
				}else {
					preIdx = idx + 1;
					idx = preIdx + 1;					
				}
			} else {
				stack.push(preIdx);
				preIdx = idx;
				idx++;
			}
		}
		if(len > 0) answer = 0;
		else answer = 1;
		return answer;
	}
}
