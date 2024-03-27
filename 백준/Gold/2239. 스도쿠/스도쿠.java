import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static class Index{
		int r;
		int c;
		public Index(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int[][] board;
	static List<Index> blankIndex;
	static StringBuilder sb;
	static boolean printed;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String line;
		
		board = new int[9][9];
		
		blankIndex = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			line = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = line.charAt(j)-'0';
				if(board[i][j] == 0)
					blankIndex.add(new Index(i, j));
			}
		}
		
		sudoku(0);
		System.out.println(sb);
	}
	
	
	public static void sudoku(int idx) {
		if(printed) return;
		if(idx == blankIndex.size()) {
			printed = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			return;
		}
		
		int r = blankIndex.get(idx).r;
		int c = blankIndex.get(idx).c;
		
		for (int i = 1; i <= 9; i++) {
			if(boardCheck(i, r, c)) {
				board[r][c] = i;
				sudoku(idx+1);
				board[r][c] = 0;
			}
		}
	}
	
	// 없는 숫자 찾기
	public static boolean boardCheck(int num, int r, int c) {
		for (int i = 0; i < 9; i++) {
			if(board[r][i] == num) return false;
			if(board[i][c] == num) return false;	
		}
		
		int startR = r/3*3;
		int startC = c/3*3;
		
		for (int i = startR; i < startR+3; i++) {
			for (int j = startC; j < startC+3; j++) {
				if(num == board[i][j])  return false;	
			}
		}
		return true;
	}
}