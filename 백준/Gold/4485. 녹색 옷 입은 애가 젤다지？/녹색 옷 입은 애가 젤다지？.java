import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Info implements Comparable<Info> {
		int r;
		int c;
		int w;

		public Info() {
		}

		public Info(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return this.w-o.w;
		}
	}

	static int N = 0;
	static int[][] board;
	static int[][] cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// 상 우 하 좌
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int tc = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			sb.append("Problem ");
			sb.append(tc++);
			sb.append(": ");

			board = new int[N][N];
			cnt = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					cnt[i][j] = Integer.MAX_VALUE;
				}
			}
			
			cnt[0][0] = board[0][0];
			
			PriorityQueue<Info> pq = new PriorityQueue<Info>();

			pq.offer(new Info(0, 0, board[0][0]));

			while (!pq.isEmpty()) {
				Info curr = pq.poll();

				if (curr.r == N - 1 && curr.c == N - 1) {
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];
					if (inBound(nr, nc) && curr.w + board[nr][nc] < cnt[nr][nc]) {
						cnt[nr][nc] = curr.w + board[nr][nc];
						pq.offer(new Info(nr, nc, curr.w + board[nr][nc]));
					}
				}
			}
			
			sb.append(cnt[N-1][N-1]);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static boolean inBound(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < N)
			return true;
		else
			return false;
	}
}