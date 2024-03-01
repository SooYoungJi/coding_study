import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int N;
	static int M;
	static int max;
	static List<int[]> blank = new ArrayList<int[]>();
	static List<int[]> virus = new ArrayList<int[]>();
	static int[] block = new int[3];
	static boolean[] isSelected;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int[][] newBoard;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		newBoard = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					blank.add(new int[] {i, j});
				}
				else if (board[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
			}
		}
		
		isSelected = new boolean[blank.size()];
		
		combi(0, 0);
		
		System.out.println(max);
	}
	
	
	public static void combi(int cnt, int start) {
		if(cnt == 3) {
			// 처음 벽 저장
			copyBoard();
			
			// 벽 만들기
			makeBlock(block);
			
			// 바이러스 전파 
			virus();
			
			// 빈칸 세기
			max = Math.max(max, countZero());			
			
			return;
		}
		
		for (int i = start; i < blank.size(); i++) {
			block[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	
	public static void copyBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
	}
	
	
	public static void makeBlock(int[] wall) {
		for (int i = 0; i < 3; i++) {
			newBoard[blank.get(wall[i])[0]][blank.get(wall[i])[1]] = 1;
		}
	}
	
	public static void virus() {
		Queue<int[]> queue = new ArrayDeque<>(virus);
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				if(0 <= curr[0]+dr[i] && curr[0]+dr[i] < N && 0 <= curr[1]+dc[i] && curr[1]+dc[i] < M
						&& newBoard[curr[0]+dr[i]][curr[1]+dc[i]] == 0) {
					newBoard[curr[0]+dr[i]][curr[1]+dc[i]] = 2;
					queue.offer(new int[] {curr[0]+dr[i], curr[1]+dc[i]});
				}
			}
		}
	}
	
	public static int countZero() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(newBoard[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(newBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}