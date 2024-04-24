import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int to;
		int w;
		
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
	}
	
	static int N;
	static int E;
	static ArrayList<Edge>[] road;
	static int N1, N2;
	static int minWay;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		road = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			road[i] = new ArrayList<Edge>();
		}
		
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			road[from].add(new Edge(to, w));
			road[to].add(new Edge(from, w));
		}
		
		st = new StringTokenizer(br.readLine());
		N1 = Integer.parseInt(st.nextToken());
		N2 = Integer.parseInt(st.nextToken());
		
		minWay = 987654321;
		
		// N1 -> N2
		int tempLen = 0;
		tempLen += dijkstra(1, N1);
		tempLen += dijkstra(N1, N2);
		tempLen += dijkstra(N2, N);
		if(tempLen > 0) {
			minWay = Math.min(minWay, tempLen);			
		}
		
		// N2 -> N1
		tempLen = 0;
		tempLen += dijkstra(1, N2);
		tempLen += dijkstra(N2, N1);
		tempLen += dijkstra(N1, N);
		if(tempLen > 0) {
			minWay = Math.min(minWay, tempLen);			
		}
		
		if(minWay >= 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(minWay);
		}
		
	}
	// 다익스트라 ?? 
	public static int dijkstra(int start, int goal) {
//		int minLen = Integer.MAX_VALUE;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		int[] weight = new int[N+1];
		Arrays.fill(weight, 987654321);
		
		pq.offer(new Edge(start, 0));
		weight[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(weight[curr.to] <curr.w)
				continue;
			
			for(Edge next : road[curr.to]) {
				if(weight[next.to] > curr.w + next.w) {
					weight[next.to] = curr.w + next.w;
					pq.offer(new Edge(next.to, weight[next.to]));
				}
			}
		}
		
		return weight[goal];
	}

}