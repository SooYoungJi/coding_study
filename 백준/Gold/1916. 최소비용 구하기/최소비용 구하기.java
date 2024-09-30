import java.io.*;
import java.util.*;

public class Main {
	public static class Node implements Comparable<Node>{
		int to;
		int dist;
		
		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
	}
	public static int N;
	public static int M;
	public static ArrayList<ArrayList<Node>> city = new ArrayList<>();
	public static int[] d;
	public static int INF = Integer.MAX_VALUE;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
//		city = new ArrayList[N+1];
//		for(int i = 0; i <= N; i++) {
//			city[i] = new ArrayList<Node>();
//		}
		
		for(int i = 0; i <= N; i++) {
			city.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			city.get(from).add(new Node(to, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		d = new int[N+1];
		Arrays.fill(d, INF);
		visited = new boolean[N+1];
		
		dijkstra(start);
		System.out.println(d[end]);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(curr.dist > d[curr.to]) continue;
			if(!visited[curr.to])
				visited[curr.to] = true;
			for(Node next: city.get(curr.to)) {
				if(!visited[next.to] && d[next.to] > d[curr.to] + next.dist) {
					d[next.to] = d[curr.to] + next.dist;
					pq.offer(new Node(next.to, d[next.to]));
				}
			}
		}
		
	}

}