import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	static int[][] visited;
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0}; 
	static int[] dc = {0, 0, -1, 1};
	static int N; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		int max = 0;
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i][j]);
			}
		}
		
		int max_safe = 0;
		for (int i = 0; i <= max; i++) {
			visited = new int[N][N];
			int count = 0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(board[j][j2] > i && visited[j][j2] == 0) {
						count++;
						DFS(new int[] {j, j2}, i);
					}
				}
			}
			max_safe = Math.max(max_safe, count);
		}
		System.out.println(max_safe);
	}
	
	public static void DFS(int[] start, int i) {
		
		visited[start[0]][start[1]] = 1;
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = start[0]+dr[dir];
			int nc = start[1]+dc[dir];
			if( inBound(nr, nc) && visited[nr][nc]==0 && board[nr][nc] > i) {
				DFS(new int[] {nr, nc}, i);
			}
		}
	}
	
	public static boolean inBound(int nr, int nc) {
		if(0 <= nr && nr < N && 0 <= nc && nc < N) return true;
		else return false;
	}

}