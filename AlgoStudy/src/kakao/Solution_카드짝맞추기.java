package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_카드짝맞추기 {
	static int[] di= {-1,1,0,0}, dj= {0,0,-1,1}; //상하좌우
	static int[] array, id, order;
	static boolean[] visit;
	static int N;
	static int[][] card;
	static List<int[]> orders;
	public static void main(String[] args) {
		String input = "[[1,0,0,3],[2,0,0,0],[0,0,0,2],[3,0,1,0]]";
		int r = 1;
		int c = 0;
		int[][] board = new int[4][4];
		
		input = input.replace("[", "").replace("]", "");
		String[] temp = input.split(",");
		for(int i=0;i<16;i++) {
			board[i/4][i%4] = temp[i].charAt(0)-'0';
		}
		System.out.println(solution(board, r, c));
	}
	public static int solution(int[][] board, int r, int c) {
        int answer = 0;
        id = new int[7];
        card = new int[7][4];
        N = 0;
        for(int i=0;i<4;i++) {
        	for(int j=0;j<4;j++) {
        		if(board[i][j] != 0) {
        			card[board[i][j]][id[board[i][j]]] = i;
        			card[board[i][j]][id[board[i][j]]+1] = j;
        			id[board[i][j]]+=2;
        			N++;
        		}
        	}
        }
        array = new int[N/2];
        visit = new boolean[7];
        order = new int[N/2];
        orders = new ArrayList<int[]>();
        order(0);
        perm(0,r,c, board);
        return answer;
    }
	public static int countMove(int r, int c, int target_r, int target_c, int[][] board) {
		int result = 0;
		boolean visit[][] = new boolean[4][4];
		while(r != target_r && c != target_c) {
			if(visit[r][c]) {
				result = -1;
				break;
			}
			visit[r][c] = true;
			if(r < target_r) { // 아래로 이동
				while(board[r][c] == 0 || (r < 4)) {
					r++;
				}
				r = r >= 4?3:r;
				result++;
			}else if(r > target_r) { // 위로 이동
				while(board[r][c] == 0 || (r >= 0)) {
					r--;
				}
				r = r < 0?0:r;
				result++;
			}else if(c < target_c) { // 오른쪽으로 이동
				while(board[r][c] == 0 || (c < 4)) {
					c++;
				}
				c = c >= 4?3:c;
				result++;
			}else if(c > target_c) { //왼쪽으로 이동
				while(board[r][c] == 0 || (c >= 0)) {
					c++;
				}
				c = c >= 4?3:c;
				result++;
			}
		}
		return result;
	}
	public static void order(int cnt) {
		if(cnt == N/2) {
			orders.add(order);
			return ;
		}
		order[cnt] = 0;
		order(cnt+1);
		order[cnt] = 2;
		order(cnt+1);
	}
	public static void perm(int cnt, int r, int c, int[][] board) {
		if(cnt == N/2) {// 짝맞출 카드 순서 정함
			System.out.println(Arrays.toString(array));
			
			for(int i=0;i<orders.size();i++) {
				order = orders.get(i);
				int sum = 0;
				for(int j=0;j<order.length;j++) {
					int count = countMove(r, c, card[array[i/2]][order[j]], card[array[i/2]][order[j]+1], board);					
					if(count < 0) break; //이 경우 버려
					
				}
				
				
			}
			
			return ;
		}
		
		for(int i=1;i<7;i++) {
			if(!visit[i] && id[i]>0) {
				array[cnt] = i;
				visit[i] = true;
				perm(cnt+1,r,c, board);
				visit[i] = false;
			}
		}
	}
	

}
