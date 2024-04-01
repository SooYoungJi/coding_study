import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] swpool;
	static boolean[][] visited;
	
	static int[] start, end;
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("../aTestStudy/res/sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			
			swpool = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					swpool[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			start = new int[] {r, c};
			
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			end = new int[] {r, c};
			//--------------------Input End-------------------
			
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);
		
		
	}
	private static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		visited = new boolean[N][N];
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		int time = 0; // 탐색 시작 시간은 0초부터 시작
		while(!q.isEmpty()) {
			int size = q.size(); // 각 시간별로 탐색을 위한 사이즈 체크 
			while(size-- > 0) {
				int[] current = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = current[0]+dr[d];
					int nc = current[1]+dc[d];
					if(!inBound(nr, nc) || visited[nr][nc] || swpool[nr][nc] == 1) {
						continue;
					}
					if(swpool[nr][nc] == 2) {
						if(time%3!=2) {
							q.offer(current.clone()); // 다음 위치 X
							continue;
						}
					}
					
					if(end[0] == nr && end[1] == nc) {
						return time+1;
					}
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
			time++;
		}
		return -1; 
	}
	
	
	public static boolean inBound(int nr, int nc) {
		if(0 <= nr && nr < N && 0 <= nc && nc < N ) return true;
		else return false;
	}

}