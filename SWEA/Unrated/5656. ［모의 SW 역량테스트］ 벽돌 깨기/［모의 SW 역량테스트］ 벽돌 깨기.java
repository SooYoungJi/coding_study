import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Block {
		int r;
		int c;
		int v;

		public Block(int r, int c, int v) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
		}

		@Override
		public String toString() {
			return "block [r=" + r + ", c=" + c + ", v=" + v + "]";
		}

	}

	static int N; // 공의 개수
	static int W; // 행 수
	static int H; // 열 수

	static int[][] board;
	static int[][] board_original;
	
	static boolean clear;

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int[] balls;
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("../ws0329/res/SWEA5656_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			board = new int[H][W];
			board_original = new int[H][W];

			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					board_original[r][c] = board[r][c];
				}
			}
			
			minCnt = Integer.MAX_VALUE;
			balls = new int[N];
			shoot(0);
			sb.append(minCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	// ball 순서 중복 조합
	public static void shoot(int cnt) {		
		if(cnt == N) {
			boardFormat();
			for (int i = 0; i < N; i++) {
				int c = balls[i];
				int r = findTop(c);
				if(r<0) continue;
				else {	
					breakBlock(new Block(r, c, board[r][c]));
					pullDown();
				}
			}
			
			minCnt = Math.min(minCnt, countBoard());
			return;
		}
		for (int i = 0; i < W; i++) {
			balls[cnt] = i;
			shoot(cnt+1);
		}
	}
	
	// 벽돌의 TOP 위치 찾기
	public static int findTop(int c) {
		int i;
		for (i = 0; i < H; i++) {
			if(board[i][c] > 0) {
				break;
			}
		}
		return i<H ? i : -1;
	}

	// BFS
	public static void breakBlock(Block start) {
		Queue<Block> queue = new ArrayDeque<Block>();

		queue.offer(start);

		while (!queue.isEmpty()) {
			Block curr = queue.poll();
            
            if(board[curr.r][curr.c] == 0) continue;
			board[curr.r][curr.c] = 0;

			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < curr.v ; i++) {
					int nr = curr.r + i * dr[d];
					int nc = curr.c + i * dc[d];
					if (inBound(nr, nc) && board[nr][nc] > 0) {
						queue.offer(new Block(nr, nc, board[nr][nc]));
					}
				}
			}
		}
	}

	public static void pullDown() {
		for (int i = H - 1; i >= 0; i--) {
			for (int j = 0; j < W; j++) {
				if (board[i][j] == 0) {
					int nr = i - 1;
					while (inBound(nr, j) && board[nr][j] == 0) {
						nr--;
					}
					if(inBound(nr, j)) {
						board[i][j] = board[nr][j];
						board[nr][j] = 0;
					}
				}
			}
		}
	}

	public static boolean inBound(int nr, int nc) {
		if (0 <= nr && nr < H && 0 <= nc && nc < W)
			return true;
		else
			return false;
	}

	public static void printBoard() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int countBoard() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(board[i][j] > 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void boardFormat() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				board[i][j] = board_original[i][j];
			}
		}
	}

}