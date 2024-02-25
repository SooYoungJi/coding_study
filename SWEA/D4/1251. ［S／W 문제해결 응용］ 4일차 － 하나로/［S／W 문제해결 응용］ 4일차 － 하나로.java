
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}	
	}
	
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	
	static int N;
	static int[] parents;
	static double E;
	static Edge[] EdgeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/SWEA1251_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int[] X = new int[N];
			int[] Y = new int[N];
			
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st1.nextToken());
				Y[i] = Integer.parseInt(st2.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			parents = new int[N];
			EdgeList = new Edge[N*(N-1)/2];
			
			int index = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					EdgeList[index++] = new Edge(i, j, getDist(new int[] {X[i], Y[i]}, new int[] {X[j], Y[j]}));
				}
			}
			
			make();
			Arrays.sort(EdgeList);
			
			double result = 0;
			int count = 0;
			for (Edge e : EdgeList) {
				if(union(e.from, e.to)) {
					result += e.weight;
					if(++count == N-1) break;
				}
			}
			
			sb.append(Math.round(result*E)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static double getDist(int[] from, int[] to) {
		return Math.pow(from[0]-to[0], 2) + Math.pow(from[1]-to[1], 2);
	}

}
