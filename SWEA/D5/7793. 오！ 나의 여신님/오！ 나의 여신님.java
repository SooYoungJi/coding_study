import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static char[][] board;
	static boolean[][] visited;
	static Queue<int[]> devilQ, goddessQ;
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
			M = Integer.parseInt(st.nextToken());

			board = new char[N][M];
			visited = new boolean[N][M];

			devilQ = new LinkedList<>();
			goddessQ = new LinkedList<>();

			for (int r = 0; r < N; r++) {
				board[r] = br.readLine().toCharArray();
				for (int c = 0; c < M; c++) {
					if (board[r][c] == 'S') {
						goddessQ.offer(new int[] { r, c });
						board[r][c] = '.';
						visited[r][c] = true;
					} else if (board[r][c] == '*') {
						devilQ.offer(new int[] { r, c });

					}
				}
			}
			// ------Input End------------------------
			int result = bfs();
			if(result<0) {
				sb.append("GAME OVER\n");
			} else {
				sb.append(result).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int bfs() {
		int time = 0;

		while (!goddessQ.isEmpty()) {
			time++;
			int size = devilQ.size();
			while (size-->0) {
				int[] currD = devilQ.poll();
				for (int d = 0; d < 4; d++) {
					int nr = currD[0] + dr[d];
					int nc = currD[1] + dc[d];
					if(inBound(nr, nc) && board[nr][nc] == '.') {
						devilQ.offer(new int[] {nr, nc});
						board[nr][nc] = '*';
					}
				}
			}
			int sooSize = goddessQ.size();
			while(sooSize-->0) {
				int[] currS = goddessQ.poll();
				for (int d = 0; d < 4; d++) {
					int nr = currS[0]+dr[d];
					int nc = currS[1]+dc[d];
					if(inBound(nr, nc)) {
						if(board[nr][nc] == 'D') {
							return time;
						}else if(!visited[nr][nc] && board[nr][nc] != '*' && board[nr][nc] != 'X' ) {
							goddessQ.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}

		return -1;
	}

	private static boolean inBound(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		else
			return false;
	}

}