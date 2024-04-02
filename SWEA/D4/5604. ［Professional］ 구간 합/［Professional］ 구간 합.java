import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	
	static long number[], result, start, end, mul;
	static void cal(long a) {
		for (long i = a; i > 0; i/=10) {
			String s = Long.toString(i);
			int t = s.charAt(s.length()-1)-'0';
			number[t]+=mul;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			
			number = new long[10];
			result = 0;
			mul = 1;
			if(start == 0) start = 1;
			while(start<=end) {
				while(start%10!=0 && start <= end) {
					cal(start);
					start++;
				}
				if(start>end) break;
				while(end%10!=9 && start <= end) {
					cal(end);
					end--;
				}
				long diff = end/10 - start/10 + 1;
				for (int i = 0; i < 10; i++) {
					number[i] += diff*mul;
				}
				mul *= 10;
				start/=10;
				end/=10;
			}
			for (int i = 0; i < 10; i++) {
				result +=(i*number[i]);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}