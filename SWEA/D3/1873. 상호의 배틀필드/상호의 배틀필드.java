import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int H;
	static int W;
	static char[][] board;
	
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int dir = 0;
	
	static int[] tank;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/SWEA1873_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			board = new char[H][W];
			tank = new int[2];
			
			for (int i = 0; i < H; i++) {
				String boardLine = br.readLine();
				for (int j = 0; j < W; j++) {
					if(boardLine.charAt(j) == '<'||boardLine.charAt(j) == '>'||boardLine.charAt(j) =='^'||boardLine.charAt(j) == 'v') {
						tank[0] = i;
						tank[1] = j;
					}
					board[i][j] = boardLine.charAt(j);
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			String input = br.readLine();
			for (int i = 0; i < N; i++) {
				switch (input.charAt(i)) {
				case 'U':
					tank[0]--;
					if(inBound(tank) && board[tank[0]][tank[1]] == '.') {
						board[tank[0]+1][tank[1]] = '.';
					}
					else tank[0]++;
					board[tank[0]][tank[1]] = '^';
//					System.out.println("U");
//					System.out.println(tank[0]+" "+tank[1]);
//					printBoard();
					break;
				case 'D':
					tank[0]++;
					if(inBound(tank) && board[tank[0]][tank[1]] == '.') {
						board[tank[0]-1][tank[1]] = '.';
					}
					else tank[0]--;
					board[tank[0]][tank[1]] = 'v';
//					System.out.println("D");
//					System.out.println(tank[0]+" "+tank[1]);
//					printBoard();
					break;
				case 'L':
					tank[1]--;
					if(inBound(tank) && board[tank[0]][tank[1]] == '.') {
						board[tank[0]][tank[1]+1] = '.';
					}
					else tank[1]++;
					board[tank[0]][tank[1]] = '<';
//					System.out.println("L");
//					System.out.println(tank[0]+" "+tank[1]);
//					printBoard();
					break;
				case 'R':
					tank[1]++;
					if(inBound(tank) && board[tank[0]][tank[1]] == '.') {
						board[tank[0]][tank[1]-1] = '.';
					}
					else tank[1]--;
					board[tank[0]][tank[1]] = '>';
//					System.out.println("R");
//					System.out.println(tank[0]+" "+tank[1]);
//					printBoard();
					break;
				case 'S':
					if(board[tank[0]][tank[1]] == '^') dir = 0;
					else if(board[tank[0]][tank[1]] == 'v') dir = 1;
					else if(board[tank[0]][tank[1]] == '<') dir = 2;
					else if(board[tank[0]][tank[1]] == '>') dir = 3;
					int[] shoot = tank.clone();
					
					while(inBound(shoot)) {
						
						int[] nShoot = new int[2];
						nShoot[0] = shoot[0]+dr[dir];
						nShoot[1] = shoot[1]+dc[dir];
						
						if(inBound(nShoot) && (board[nShoot[0]][nShoot[1]] == '.' || board[nShoot[0]][nShoot[1]] == '-')) {
							shoot[0] = nShoot[0];
							shoot[1] = nShoot[1];
						}
						else if(inBound(nShoot) && board[nShoot[0]][nShoot[1]] == '*') {
							board[nShoot[0]][nShoot[1]] = '.';
							break;
						}
						else if(inBound(nShoot) && board[nShoot[0]][nShoot[1]] == '#') {
							break;
						}
						else
							break;
					}
//					System.out.println("S");
//					printBoard();
					break;
				}
				
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean inBound(int[] shoot) {
		if(shoot[0]>=0 && shoot[0]<H && shoot[1]>=0 && shoot[1]<W ) return true;
		else return false;
	}
	
//	private static void printBoard() {
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}