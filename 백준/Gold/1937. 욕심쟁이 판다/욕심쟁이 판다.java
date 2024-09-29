import java.io.*;
import java.util.*;

public class Main {

	public static int N;
	public static int[][] forest;
	public static int[][] dp;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, 1, -1};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		forest = new int[N][N];
		dp = new int[N][N];
//		for(int i = 0; i < N; i++) {
//			Arrays.fill(dp, -1);
//		}
//		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxCount = 0;
		
		for(int i =0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				maxCount = Math.max(maxCount, DFS(i, j));
			}
		}
		
		System.out.println(maxCount);
	}
	
	public static int DFS(int r, int c) {
		
		
		if(dp[r][c] != 0) {
			return dp[r][c];
		}
		
		dp[r][c] = 1;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(inBound(nr, nc) && forest[nr][nc] > forest[r][c]) {
				dp[r][c] = Math.max(dp[r][c], DFS(nr, nc)+1);
//				print();
//				DFS(nr, nc);
			}
		}
		
		return dp[r][c];
	}
	
	public static boolean inBound(int nr, int nc) {
		if(0 <= nr && nr < N && 0 <= nc && nc < N) {
			return true;
		}
		else return false;
		
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();		
	}

}