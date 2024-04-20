import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int Max = 0;
		
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = 0;
			while(st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				if(i > 0) {
					if(c == 0) {
						board[i][c] = board[i-1][c]+temp;
					} else if(c < N-1) {
						board[i][c] = Math.max(board[i-1][c-1]+temp, board[i-1][c]+temp);
					} else if(c == N-1) {
						board[i][c] = board[i-1][c-1]+temp;
					}
				} else {
					board[i][c] = temp;
				}
				Max = Math.max(Max, board[i][c]);
				c++;
			}
		}
//		printTri(board);
		System.out.println(Max);
	}
//	public static void printTri(int[][] board) {
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}