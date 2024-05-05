
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int minT;
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] start;
	static int[] end;
	// 상 하 좌 우 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			start = new int[] {r, c};
			
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			end = new int[] {r, c};
			
			sb.append(swim()).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int swim() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		visited = new boolean[N][N];
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		
		int time = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				int[] curr = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + dr[i];
					int nc = curr[1] + dc[i];
					if(!inBound(nr, nc)) continue;
					if(visited[nr][nc]) continue;
					if(board[nr][nc] == 1) continue;
					if(board[nr][nc] == 2) {
						if(time % 3 != 2) {
							queue.offer(curr.clone());
							continue;
						}
					}
					if(end[0] == nr && end[1]==nc) {
						return time+1;
					}
					
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
			time++;
		}
		return-1;
		
	}
	
	public static boolean inBound(int nr, int nc) {
		if(0 <= nr && nr < N && 0 <= nc && nc < N) return true;
		else return false;
	}

}
