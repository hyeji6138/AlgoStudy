package level1;

import java.util.Arrays;

public class Solution_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25}, win_nums= {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] nums = new boolean[46];
        for(int i=0;i<6;i++) {
        	nums[win_nums[i]] = true;
        }
        int correctCnt = 0, zeroCnt = 0;
        for(int i=0;i<6;i++) {
        	if(nums[lottos[i]]) correctCnt++;
        	if(lottos[i] == 0) zeroCnt++;
        }
        answer[0] = rank(correctCnt+zeroCnt);
        answer[1] = rank(correctCnt);
        return answer;
    }
	public static int rank(int score) {
		if(score == 6) {
			return 1;
		}else if(score == 5) {
			return 2;
		}else if(score == 4) {
			return 3;
		}else if(score == 3) {
			return 4;
		}else if(score == 2) {
			return 5;
		}else {
			return 6;
		}
	}

}
