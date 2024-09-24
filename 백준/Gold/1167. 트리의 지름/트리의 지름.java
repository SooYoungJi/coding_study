import java.io.*;
import java.util.*;

public class Main {
	public static class Node{
		int next;
		int length;
		
		public Node(int next, int length) {
			this.next = next;
			this.length = length;
		}
	}
	
	public static ArrayList<Node>[] tree;
	public static boolean[] visited;
	public static int max = 0;
	public static int node;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[V+1];
		for(int i = 1; i < V+1; i++) {
			tree[i] = new ArrayList<>();
		}		
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next==-1) break;
				int length = Integer.parseInt(st.nextToken());
				tree[start].add(new Node(next, length));
			}
		}
		
		visited = new boolean[V+1];
		dfs(1, 0);
		
		visited = new boolean[V+1];
		dfs(node, 0);
		
		System.out.println(max);
		
		
	}
	
	public static void dfs(int x, int len) {
		if(len>max) {
			max = len;
			node = x;
		}
		visited[x] = true;
		for(int i = 0; i < tree[x].size(); i++) {
			Node n = tree[x].get(i);
			if(!visited[n.next]) {
				dfs(n.next, n.length+len);
				visited[n.next] = true;
			}
		}
	}
}