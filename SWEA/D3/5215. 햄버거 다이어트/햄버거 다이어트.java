import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] ingredients;
	static boolean[] hamburgers;
	static int N;
	static int L;
	static int max;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/SWEA5215_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredients = new int[N][N];
			for (int i = 0; i < N; i++) {
				max = 0;
				hamburgers = new boolean[N];
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}
			combi(0);
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void combi(int cnt) {
		if(cnt == N) {
			int score = 0;
			int cal = 0;
			for (int i = 0; i < N; i++) {
				if(hamburgers[i]) {
					score += ingredients[i][0];
					cal += ingredients[i][1];
				}
			}
			if(cal <= L) max = Math.max(max, score);
			return;
		}
		hamburgers[cnt] = true;
		combi(cnt+1);
		hamburgers[cnt] = false;
		combi(cnt+1);
		
		
	}

}