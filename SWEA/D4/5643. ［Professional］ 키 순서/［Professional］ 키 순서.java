import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int M;
	
	static List<Integer>[] boardUp;
	static List<Integer>[] boardDown;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			boardUp = new ArrayList[N+1];
			boardDown = new ArrayList[N+1];
			
			for (int i = 0; i <= N; i++) {
				boardUp[i] = new ArrayList<Integer>();
				boardDown[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				boardUp[a].add(b);
				boardDown[b].add(a);
			}
			
			int answer = 0;
			
			for (int i = 1; i <= N; i++) {
				int totalCnt = 0;
				totalCnt += findUp(i);
				totalCnt += findDown(i);
				if(totalCnt == N-1) {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	// 위의 노드 탐색
	public static int findUp(int node) {
		int cnt = 0;
		visited = new boolean[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(node);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int i : boardUp[curr]) {
				if(!visited[i]) {
					visited[i] = true;
					cnt+=1;
					queue.add(i);
				}
			}
		}
		return cnt;
	}
	
	// 아래의 노드 탐색
		public static int findDown(int node) {
			int cnt = 0;
			Queue<Integer> queue = new ArrayDeque<>();
			
			queue.add(node);
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				for(int i : boardDown[curr]) {
					if(!visited[i]) {
						visited[i] = true;
						cnt+=1;
						queue.add(i);
					}
				}
			}
			return cnt;
		}
}