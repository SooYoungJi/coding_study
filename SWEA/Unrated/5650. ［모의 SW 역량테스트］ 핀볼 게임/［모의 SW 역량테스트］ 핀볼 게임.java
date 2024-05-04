import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static class Ball{
		int r;
		int c;
		int dir;
		int cnt;
		
		public Ball(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static int N;
	static int[][] board, warmH;
	static int maxScore;
	//상 하 좌 우 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
		
			N = Integer.parseInt(br.readLine().trim());
			board = new int[N+2][N+2];
			warmH = new int[11][4];
			
			for (int r = 1; r < N+1; r++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int c = 1; c < N+1; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					if(board[r][c] > 5) {
						int num = board[r][c];
						if(warmH[num][0] == 0 && warmH[num][1] == 0) {
							warmH[num][0] = r;
							warmH[num][1] = c;
						} else {
							warmH[num][2] = r;
							warmH[num][3] = c;
						}
					}
				}
			}
			
			for (int i = 0; i < N+2; i++) {
				board[i][0] = 5;
				board[0][i] = 5;
				board[N+1][i] = 5;
				board[i][N+1] = 5;
			}

			maxScore = 0;
			
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N+1; c++) {
					if(board[r][c] == 0) {
						board[r][c] = -1;
						game(r, c);
						board[r][c] = 0;
					}
				}
			}
			
			sb.append(maxScore).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void game(int r, int c) {
		for (int d = 0; d < 4; d++) {
			Ball ball = new Ball(r, c, d);
			while(true) {
				// 아무것도 만나지 않을 때까지 직진 
				while(true) {
					ball.r += dr[ball.dir];
					ball.c += dc[ball.dir];
					if(board[ball.r][ball.c]!=0) break;
				}
				
				// 0이 아닌 무엇일 때
				// 1. 블랙홀을 만났을 때, 게임 끝, 점수 갱신 
				if(board[ball.r][ball.c] == -1) {
					maxScore = Math.max(maxScore, ball.cnt);
					break;
				} else if(board[ball.r][ball.c] > 5) {
					// 2. 웜홀을 만났을 때, 다른 웜홀로 이동 방향 포함 
					int num = board[ball.r][ball.c];
					if(warmH[num][0] == ball.r && warmH[num][1] == ball.c) {
						ball.r = warmH[num][2];
						ball.c = warmH[num][3];
					} else {
						ball.r = warmH[num][0];
						ball.c = warmH[num][1];
					}
				}else if(board[ball.r][ball.c] <= 5){
					// 3. 블록을 만났을 때, 방향 전환, 점수 up! 
					ball.dir = changeDir(ball.dir, board[ball.r][ball.c]);
					ball.cnt++;
				}
			}
		}
	}
	public static int changeDir(int dir, int block) {
		if(block == 1) {
			if(dir == 0) {
				return 1;				
			}else if(dir == 1) {
				return 3;
			}else if(dir == 2) {
				return 0;
			}else {
				return 2;
			}
		}else if(block == 2) {
			if(dir == 0) {
				return 3;				
			}else if(dir == 1) {
				return 0;
			}else if(dir == 2) {
				return 1;
			}else {
				return 2;
			}
		}else if(block == 3) {
			if(dir == 0) {
				return 2;				
			}else if(dir == 1) {
				return 0;
			}else if(dir == 2) {
				return 3;
			}else {
				return 1;
			}
		}else if(block == 4) {
			if(dir == 0) {
				return 1;				
			}else if(dir == 1) {
				return 2;
			}else if(dir == 2) {
				return 3;
			}else {
				return 0;
			}
		}else{
			if(dir == 0) {
				return 1;				
			}else if(dir == 1) {
				return 0;
			}else if(dir == 2) {
				return 3;
			}else {
				return 2;
			}
		}
	}
}