import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("../ws0328/res/SWEA1263_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			board = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int v = Integer.parseInt(st.nextToken());
					if(i==j)continue;
					else if(v == 0) board[i][j] = 100;
					else board[i][j] = v;
				}
			}
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					if(i == k) 
						continue;
					for (int j = 1; j <= N; j++) {
						if(i==j) {
							board[i][j] = 0;
						}else if(j == k) {
							continue;
						}else {
							board[i][j] = Math.min(board[i][k]+board[k][j], board[i][j]);
						}
					}
				}
				
			}
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= N; j++) {
					sum += board[i][j];
				}
				min = Math.min(min, sum);
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void printBoard() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}