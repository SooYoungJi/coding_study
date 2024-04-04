import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, adj[][], cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			
			adj = new int [N+1][N+1];
			for (int i = 1; i <= N; i++) {
				adj[i][0] = -1;
			}
			
			StringTokenizer st = null;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] == -1) dfs(i);
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[0][j] += adj[i][j];
				}
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if(adj[i][0]+adj[0][i] == N-1) ++ans;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	private static void dfs(int cur) {
		for (int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1) {
				if(adj[i][0] == -1) { // 탐색이 안된 학생 탐색하기
					dfs(i);
				}
				// i 학생보다 큰 학생이 있다면 그 관계들을 자신과의 관계에 반영
				if(adj[i][0] > 0) {
					for(int j=1; j <= N; j++) {
						if(adj[i][j] == 1) { // i보다 큰 학생 j를 나 cur과의 관계로 표현
							adj[cur][j] = 1;
						}
					}
				}
				
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) { // 자신보다 큰 학생 수 카운팅 (0은 덧셈에
			cnt += adj[cur][i];
		}
		adj[cur][0] = cnt;
	}
	

}