import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int B;
	
	static int[] member;
	static boolean[] visited;
	
	static int min;
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			member = new int[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				member[i] = Integer.parseInt(st.nextToken());
			}
			
			find(0);
			
			sb.append(min-B).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void find(int cnt) {
		if(cnt == N) {
			int total = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					total += member[i];
				}
			}
			if(total >= B) min = Math.min(min, total);
			return;
		}
		
		visited[cnt] = true;
		find(cnt+1);
		visited[cnt] = false;
		find(cnt+1);
	}
	
	

}