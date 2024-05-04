import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, H, W;
	static int[][] originalBoard;
	static int[][] board;
	static int leftOver;
	static int[] start;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			originalBoard = new int[H][W];
			board = new int[H][W];

			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					originalBoard[r][c] = Integer.parseInt(st.nextToken());
					board[r][c] = originalBoard[r][c];
				}
			}

			start = new int[N];
			leftOver = Integer.MAX_VALUE;

			game(0);

			sb.append(leftOver).append("\n");
		}
		System.out.println(sb);
	}

	public static void game(int cnt) {
		if (cnt == N) {
			// 보드 갱신
			boardCopy();
			// 게임 진행
			for (int i = 0; i < N; i++) {
				shoot(start[i]);
				pullDown();
			}
			leftOver = Math.min(leftOver, countBrick());
			return;
		}

		for (int i = 0; i < W; i++) {
			start[cnt] = i;
			game(cnt + 1);
		}

	}

	// 벽돌 깨기 BFS
	public static void shoot(int start) {
		int r = 0;
		int c = start;
		// 정확한 시작 위치 찾기
		for (r = 0; r < H; r++) {
			if (board[r][c] > 0)
				break;
		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		if (inBound(r, c)) {
			queue.offer(new int[] { r, c, board[r][c] });
		}
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			int ct = curr[2];
			for (int dir = 0; dir < 4; dir++) {
				for (int i = 0; i < ct; i++) {
					int nr = cr + dr[dir] * i;
					int nc = cc + dc[dir] * i;
					if (inBound(nr, nc) && board[nr][nc] > 0) {
						queue.offer(new int[] { nr, nc, board[nr][nc] });
						board[nr][nc] = 0;
					}
				}
			}
		}
	}

	// 남은 갯수 계산
	public static int countBrick() {
		int cnt = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (board[r][c] > 0)
					cnt++;
			}
		}
		return cnt;
	}

	// 끌어내리기
	public static void pullDown() {
		for (int c = 0; c < W; c++) {
			for (int r = H - 1; r >= 0; r--) {
				if (board[r][c] == 0) {
					int nr = r;
					while (inBound(nr, c) && board[nr][c] == 0) {
						nr--;
					}
					if (inBound(nr, c)) {
						board[r][c] = board[nr][c];
						board[nr][c] = 0;
					}
				}
			}
		}
	}

	// 보드 복사
	public static void boardCopy() {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				board[r][c] = originalBoard[r][c];
			}
		}
	}

	public static boolean inBound(int r, int c) {
		if (0 <= r && 0 <= c && r < H && c < W)
			return true;
		else
			return false;
	}

	public static void printBoard() {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}

}