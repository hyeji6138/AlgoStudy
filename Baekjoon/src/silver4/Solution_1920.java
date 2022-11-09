package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1920 { // 수 찾기
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!hash.contains(num)) {
				hash.add(num);
			}
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hash.contains(num)) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
