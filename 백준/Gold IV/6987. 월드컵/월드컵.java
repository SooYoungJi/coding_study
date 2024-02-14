import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] match;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 4; i++) {
			match = new int[6][3];
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				sum += match[j][0] = Integer.parseInt(st.nextToken());
				sum += match[j][1] = Integer.parseInt(st.nextToken());
				sum += match[j][2] = Integer.parseInt(st.nextToken());
			}
			
			if(sum != 30) {
				sb.append("0 ");
				continue;
			}
			
			flag = false;
			dfs(0, 0, 1);
			if(flag) sb.append("1 ");
			else sb.append("0 ");
		}
		System.out.println(sb);
	}
	
	static void dfs(int count, int t1, int t2) {
		if(flag) return;
		
		if(count == 15) {
			flag = true;
			return;
		}
		
		int nt1 = t1;
		int nt2 = t2+1;
		
		if(t2 ==5) {
			nt1 = t1 + 1;
			nt2 = nt1 + 1;
		}
		
		for (int m = 0; m < 3; m++) {
			if(match[t1][m] > 0 && match[t2][2-m]>0) {
				match[t1][m]--;
				match[t2][2-m]--;
				
				dfs(count+1, nt1, nt2);
				match[t1][m]++;
				match[t2][2-m]++;
			}
		}
	}
}