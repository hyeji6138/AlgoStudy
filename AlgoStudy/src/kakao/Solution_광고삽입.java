package kakao;

public class Solution_광고삽입 {
	public static void main(String[] args) {
		String play_time = "99:59:59";
		String adv_time = "25:00:00";
		String[] logs = { "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

		System.out.println(solution(play_time, adv_time, logs));

	}
	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		int[] play = strTimeToIntTime(play_time);
		int[] adv = strTimeToIntTime(adv_time);
		
		int[][][] time = new int[play[0]+1][60][60];
		for(int i=0;i<logs.length;i++) {
			String[] watch_times = logs[i].split("-");
			int[] start_time = strTimeToIntTime(watch_times[0]);
			int[] end_time = strTimeToIntTime(watch_times[1]);
			
			int t=calTotalTime(start_time);
			int end = calTotalTime(end_time);
			while(t < end) {
				int[] temp = sumTimeToIntTime(t);
				time[temp[0]][temp[1]][temp[2]]++;
				t++;
			}
		}
		int sumTime = 0;
		int maxTime = 0;
		int maxIdx = 0;
		int playsum = calTotalTime(play);
		int advsum = calTotalTime(adv);
		int t=0;
		while(t < advsum) {
			int[] temp = sumTimeToIntTime(t);
			sumTime += time[temp[0]][temp[1]][temp[2]];
			t++;
		}
		
		maxTime = sumTime;
		
		int prev = 0;
		int next = advsum;
		while(prev < playsum-advsum) {
			int[] minusIdx = sumTimeToIntTime(prev);
			int[] plusIdx =  sumTimeToIntTime(next);
			sumTime = sumTime - time[minusIdx[0]][minusIdx[1]][minusIdx[2]] +time[plusIdx[0]][plusIdx[1]][plusIdx[2]]; 
			if(maxTime < sumTime) {
				maxTime = sumTime;
				maxIdx = prev+1;
			}
			prev++;
			next++;
		}
		int[] ans = sumTimeToIntTime(maxIdx);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<3;i++) {
			if(ans[i]<10) sb.append("0");
			sb.append(ans[i]+":");
		}
		answer = sb.substring(0, sb.length()-1);
		return answer;
	}
	
	public static int[] sumTimeToIntTime(int time) {
		int[] result = {time/3600, (time/60)%60, time%60};
		return result;
	}
	
	public static int calTotalTime(int[] time) {
		int result = 0;
		for(int i=0;i<3;i++) {
			result += (int)Math.pow(60, (2-i))*time[i];
		}
		return result;
	}
	
	public static int[] strTimeToIntTime(String time) {
		String[] times = time.split(":");
		int[] result = new int[3];
		for(int i=0;i<3;i++) {
			result[i] = (times[i].charAt(0)-'0')*10 +(times[i].charAt(1)-'0'); 
		}
		return result;
	}

}
