package level1;

public class Solution_약수의개수와덧셈 {
	public static void main(String[] args) {
		int left = 13, right = 17;
		System.out.println(solution(left, right));
	}
	public static int solution(int left, int right) {
        int answer = 0;
        
        for(int n=left;n<=right;n++) {
        	if(cntDivisor(n) % 2 == 0) answer += n;
        	else answer -= n;        	
        }
        
        return answer;
    }
	public static int cntDivisor(int num) {
		int cnt = 0;
		for(int i=1;i<=num;i++) {
			if(num % i == 0) cnt++;
		}
		return cnt;
	}
}
