import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] board;
	static int isAble;
	static int[] end = new int[2];
	
	// 상 우 하 좌 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/SWEA1227_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(br.readLine()).append(" ");
			board = new int[100][100];
			int[] start = new int[2];
			for (int i = 0; i < 100; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < 100; j++) {
					if(Integer.parseInt(line[j]) == 2) {
						start[0] = i;
						start[1] = j;
					}
					else if(Integer.parseInt(line[j]) == 3) {
						end[0] = i;
						end[1] = j;
					}
					board[i][j] = Integer.parseInt(line[j]);
				}
			}
			isAble = 0;
			bfs(start);
			sb.append(isAble).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	
	static void bfs(int[] start) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[100][100];
		
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			if(current[0]==end[0] && current[1]==end[1]) {
				isAble = 1;
				
			}
			
			
			for (int i = 0; i < 4; i++) {
				if(board[current[0]+dr[i]][current[1]+dc[i]] != 1 && !visited[current[0]+dr[i]][current[1]+dc[i]]) {
					int[] nc = new int[2];
					nc[0] = current[0] + dr[i]; 
					nc[1] = current[1] + dc[i]; 
					visited[nc[0]][nc[1]] = true;
					queue.offer(nc);
				}
			}
		}	
	}
}