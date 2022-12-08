package level2;

public class Solution_방금그곡 {
	public static void main(String[] args) {
		String m = "ABCDEFG";
		String[] musicinfos = { "11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB" };
		System.out.println(solution(m, musicinfos));
	}

	public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		m = convertSemitone(m);
		int maxTime = 0;
		for (int i = 0; i < musicinfos.length; i++) {
			String[] data = musicinfos[i].split(",");
			int len = musicLength(data[0], data[1]);
			data[3] = convertSemitone(data[3]);
			if (len < m.length()) continue;
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < len; j++) {
				sb.append(data[3].charAt(j % data[3].length()));
			}
			int idx = sb.indexOf(m);
			if (idx >= 0 && maxTime < len) {
				answer = data[2];
				maxTime = len;
			}
		}
		return answer;
	}

	public static String convertSemitone(String s) {
		String[] scale = { "C#", "D#", "F#", "G#", "A#" };
		for (int i = 0; i < scale.length; i++) {
			s = s.replace(scale[i], Integer.toString(i));
		}
		return s;
	}

	public static int musicLength(String time1, String time2) {
		return StringToTime(time2) - StringToTime(time1);
	}

	public static int StringToTime(String time) {
		String[] times = time.split(":");
		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
	}

}
