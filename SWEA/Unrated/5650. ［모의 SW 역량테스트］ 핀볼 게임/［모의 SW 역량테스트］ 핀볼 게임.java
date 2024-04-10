import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class Ball{
		int r;
		int c;
		int dir;
		int count;
		public Ball(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}
	
	static int T, N;
	static int Max;
	static int[][] board, warmH;
	// 상 우 하 좌 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine().trim());
			board = new int[N+2][N+2];
			warmH = new int[11][4];
			Max = Integer.MIN_VALUE;
			
			for (int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int c = 1; c <= N; c++) {
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
			
			for (int i = 0; i < N+1; i++) {
				board[i][0] = 5;
				board[0][i] = 5;
				board[N+1][i] = 5;
				board[i][N+1] = 5;
			}
			//--------input end-------------------------
			
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if(board[r][c] == 0) {
						board[r][c] = -1;
						move(r, c);
						board[r][c] = 0;
					}
				}
			}
			sb.append(Max).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void move(int r, int c) {
		for (int d = 0; d < 4; d++) {
			Ball b = new Ball(r, c, d);
			while(true) {
				while(true) {
					b.r += dr[b.dir];
					b.c += dc[b.dir];
					if(board[b.r][b.c] != 0) {
						break;
					}
				}
				
				// 0이 아닌 것들을 만났을 때 처리할 내용들 
				// 1. 블랙홀을 만났을 때(출발지 포함)
				if(board[b.r][b.c] == -1) {
					Max = Math.max(Max, b.count);
					break;
				} else if(board[b.r][b.c] > 5) {// 2. 웜홀을 만났을 때 (방향을 바꾸지 X, 위치만 이동)
					int num = board[b.r][b.c];
					if(warmH[num][0] == b.r && warmH[num][1] == b.c) {
						b.r = warmH[num][2];
						b.c = warmH[num][3];
					} else {
						b.r = warmH[num][0];
						b.c = warmH[num][1];
					}
				} else if(board[b.r][b.c] <= 5) { // 3. 블럭을 만났을 때 (블럭 번호에 따라서 방향 바꿈, 점수 올려주기)
					b.dir = changeDir(board[b.r][b.c], b.dir);
					b.count++;	
				} 
			}
		}
	}
	
	private static int changeDir(int wall, int dir) {
		if(wall == 1) {
			if(dir == 0) {
				return 2;
			} else if(dir == 1) {
				return 3;
			} else if(dir == 2) {
				return 1;
			} else {
				return 0;
			}
		} else if(wall == 2) {
			if(dir == 0) {
				return 1;
			} else if(dir == 1) {
				return 3;
			} else if(dir == 2) {
				return 0;
			} else {
				return 2;
			}
		} else if(wall == 3) {
			if(dir == 0) {
				return 3;
			} else if(dir == 1) {
				return 2;
			} else if(dir == 2) {
				return 0;
			} else {
				return 1;
			}
		} else if(wall == 4){
			if(dir == 0) {
				return 2;
			} else if(dir == 1) {
				return 0;
			} else if(dir == 2) {
				return 3;
			} else {
				return 1;
			}
		} else {
			if(dir == 0) {
				return 2;
			} else if(dir == 1) {
				return 3;
			} else if(dir == 2) {
				return 0;
			} else {
				return 1;
			}
		}
	}

}