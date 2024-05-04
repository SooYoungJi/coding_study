import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int D, W, K;
	static int[][] board;
	static int minCnt;
	static int[] chemical;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[D][W];
			minCnt = K+1;
			chemical = new int[D];
			
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0);
			
			sb.append(minCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int inputCnt, int row) {
		if(inputCnt > K)
			return;
		if(inputCnt >= minCnt)
			return;
		if(row==D) {
			if(check()) {
				minCnt = Math.min(minCnt, inputCnt);
			}
			
			return;
		}
		
		for (int i = -1; i < 2; i++) {
			chemical[row] = i;
			if(i == -1) {
				dfs(inputCnt, row+1);
			}else {
				dfs(inputCnt+1, row+1);
			}
		}
		
	}
	
	static boolean check() {
		int cnt = 0;
		int cur, next;
		for (int c = 0; c < W; c++) {
			cnt = 1;
			for (int r = 0; r < D-1; r++) {
				cur = chemical[r] == -1? board[r][c] : chemical[r];
				next = chemical[r+1] == -1? board[r+1][c] : chemical[r+1];
				
				if(cur == next) {
					cnt++;
					if(cnt >= K) {
						break;
					}
				} else {
					cnt = 1;
				}
			}
			if(cnt < K) {
				return false;
			}
		}
		return true;
	}
}