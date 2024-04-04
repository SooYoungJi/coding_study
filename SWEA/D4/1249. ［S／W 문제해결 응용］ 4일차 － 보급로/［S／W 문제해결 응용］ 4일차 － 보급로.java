import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	
	static int N;
	static int[][] board;
	static int[][] dist;
	
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Info implements Comparable<Info>{
		int r;
		int c;
		int w;
		public Info(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Info o) {
			return this.w-o.w;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("../ws0404/res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; i++) {
				char[] st = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					board[i][j] = st[j]-'0';
				}		
			}
			int ans = dijkstra();
//			System.out.println(ans);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int dijkstra() {
		PriorityQueue<Info> pq = new PriorityQueue<Info>();
		
		pq.offer(new Info(0, 0, board[0][0]));
		
		while(!pq.isEmpty()) {
			Info curr = pq.poll();
			
			if(curr.r == N-1 && curr.c == N-1) {
				break;
			}
			
			if(dist[curr.r][curr.c] < curr.w) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(inBound(nr, nc) && dist[nr][nc] > curr.w + board[nr][nc]) {
					dist[nr][nc] = curr.w + board[nr][nc];
					pq.add(new Info(nr, nc, dist[nr][nc]));
				}
			}
		}
		return dist[N-1][N-1];
	}
	
	public static boolean inBound(int nr, int nc) {
		if(0 <= nr && nr < N && 0 <= nc && nc < N) return true;
		else return false;
	}
}