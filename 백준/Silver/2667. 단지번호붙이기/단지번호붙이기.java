import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int N;
	static int[][] board;
//	static int[][] danji;
	static List<Integer> danji;
	
	//상 하 좌 우 	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
//		danji = new int[N][N];
		
		danji = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = line[j]-'0';
			}
		}
		
		//BFS flood fill
		int cnt = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(board[r][c] == 1) {
					cnt++;
					BFS(cnt, new int[] {r, c});
				}
			}
		}
		
		Collections.sort(danji);
		sb.append(cnt-1).append("\n");
		for (int i = 0; i < danji.size(); i++) {
			sb.append(danji.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
	public static void BFS(int cnt, int[] input) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		int danjiCnt = 1;
		queue.add(input);
		board[input[0]][input[1]] = cnt;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(inBound(nr, nc) && board[nr][nc] == 1) {
					board[nr][nc] = cnt;
					danjiCnt++;
					queue.add(new int[] {nr, nc});
				}
			}
		}
		danji.add(danjiCnt);
	}
	
	public static boolean inBound(int nr, int nc) {
		if(0 <= nr && nr < N && 0 <= nc && nc < N) return true;
		else return false;
	}
	
	public static void printBoard() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}