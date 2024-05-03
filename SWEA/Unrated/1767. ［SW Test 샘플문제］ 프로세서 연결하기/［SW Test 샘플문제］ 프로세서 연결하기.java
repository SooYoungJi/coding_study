import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	
	static int N;
	static int[][] board;
	static List<int[]> processor;
	// 상 하 좌 우 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] dirs;
	static int processCnt;
	
	static int maxProcess;
	static int minLength;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			processor = new ArrayList<>();
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					if(board[r][c] == 1) {
						processor.add(new int[] {r, c});
					}
				}
			}
			processCnt = processor.size();
			dirs = new int[processCnt];
			minLength = Integer.MAX_VALUE;
			maxProcess = 0;
			
			perm(0, 0);
			
			
			sb.append(minLength).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void perm(int cnt, int max) {
		if(max+(processCnt-cnt) < maxProcess) return;
			
		if(cnt == processCnt) {
			if(max > maxProcess) {
				maxProcess = max;
				minLength = count();
			}else if(max == maxProcess){
				minLength = Math.min(minLength, count());
			}
			return;
		}
		
		
		for (int dir = 0; dir < 4; dir++) {
			int x = processor.get(cnt)[0]+dr[dir];
			int y = processor.get(cnt)[1]+dc[dir];
			if(go(x, y, dir)) {
				perm(cnt+1, max+1);
				while(x >= 0 && y >= 0 && x < N && y < N) {
					board[x][y] = 0;
					x += dr[dir];
					y += dc[dir];
				}
			}else {
				perm(cnt+1, max);
			}
		}
	}
	
	public static int count() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(board[r][c] == 2) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static boolean go(int r, int c, int dir) {
		
		if(r < 0 || c < 0 || r >= N || c >= N) {
			return true;
		}
		
		if(board[r][c] != 0) {
			return false;
		}
		
		board[r][c] = 2;
		
		boolean flag = go(r+dr[dir], c+dc[dir], dir);
		if(!flag) {
			board[r][c] = 0;
		}
		
		return flag;
	}

}