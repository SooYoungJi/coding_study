import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static int[][] board;
	static int[][] visited;
	
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	
	static int min_cnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String row[] = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(row[j]);
			}
		}
		
//		printBoard(board);
		
		BFS();
		
		System.out.println(min_cnt);
		
	}
	
	public static void BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {0, 0, 0});
		visited[0][0] = 0;
		
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			if(curr[0] == N-1 && curr[1] == M-1) {
				min_cnt = Math.min(min_cnt, curr[2]+1);
			}
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0]+dr[dir];
				int nc = curr[1]+dc[dir];
				if(inBound(nr, nc) && board[nr][nc] == 1 && visited[nr][nc] == 0) {
					visited[nr][nc] = curr[2]+1;
//					printBoard(visited);
					queue.offer(new int[] {nr, nc, curr[2]+1});
				}
			}
		}
	}
	
	public static boolean inBound(int nr, int nc) {
		if(0 <= nr && nr < N && 0 <= nc && nc < M) return true;
		else return false;
	}
	
	public static void printBoard(int[][] prints) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(prints[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}