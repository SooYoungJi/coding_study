import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Index {
		int t;
		int r;
		int c;

		public Index(int t, int r, int c) {
			super();
			this.t = t;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Index [t=" + t + ", r=" + r + ", c=" + c + "]";
		}

	}

	static int R;
	static int C;

	static char[][] board;
	static char[][] waterTest;
	static int[][] waterBoard;
	static boolean[][] visited;

	static Index end;
	static Index start;
	static List<Index> water;

	// 상 하 우 좌
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	
	static boolean arrived;
	static int time = Integer.MAX_VALUE;
	
	static Queue<Index> queue = new ArrayDeque<Index>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		waterTest = new char[R][C];
		waterBoard = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			waterTest[i] = board[i].clone();
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'D')
					end = new Index(0, i, j);
				else if (board[i][j] == 'S')
					start = new Index(0, i, j);
				else if (board[i][j] == '*')
					queue.add(new Index(0, i, j));
			}
		}
		
		waterBoard[end.r][end.c] = -1;
		waterFill();
//		printWater();
		visited[start.r][start.c] = true;
		letsGo();
		
//		printWater();
		if(arrived)
			System.out.println(time);
		else
			System.out.println("KAKTUS");
	}

	// 물이 퍼지는 시간 기록
	public static void waterFill() {

		while (!queue.isEmpty()) {
			Index curr = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if (inBound(nr, nc) && (waterTest[nr][nc] == '.' || waterTest[nr][nc] == 'S')) {
					waterBoard[nr][nc] = curr.t + 1;
					waterTest[nr][nc] = '*';
					queue.offer(new Index(curr.t + 1, nr, nc));
				}
			}
		}

	}

	public static void letsGo() {
		Queue<Index> queue = new ArrayDeque<Index>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Index curr = queue.poll();
			
//			System.out.println(curr.toString());
//			printBoard();
//			printWater();
			
			if(curr.r == end.r && curr.c == end.c) {
				arrived = true;
				time = Math.min(curr.t, time);
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(inBound(nr, nc)&& !visited[nr][nc] && (waterBoard[nr][nc] == -1||waterBoard[nr][nc]==0||curr.t+1 < waterBoard[nr][nc])  && board[nr][nc] != 'X' && board[nr][nc] != '*') {
					visited[nr][nc] = true;
					queue.offer(new Index(curr.t + 1, nr, nc));
				}
			}
		}
	}
	
	public static boolean inBound(int nr, int nc) {
		if (0 <= nr && nr < R && 0 <= nc && nc < C)
			return true;
		else
			return false;
	}

	public static void printWater() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(waterBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printBoard() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}