import java.io.*;
import java.util.*;

public class Main {
	
	public static class Cut implements Comparable<Cut>{
		int index;
		int diff;
		
		public Cut(int index, int diff) {
			this.index = index;
			this.diff = diff;
		}
		
		@Override
		public int compareTo(Cut o) {
			return o.diff - this.diff;
		}
	}
	public static int N;
	public static int K;
	public static int[] S;
	public static PriorityQueue<Cut> SDiff;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		S = new int[N];
		SDiff = new PriorityQueue<>();
		int total = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			if(i > 0) {
				SDiff.add(new Cut(i, S[i]-S[i-1]));
				total+=S[i]-S[i-1];
			}
		}
		
		for(int i = 0; i < K-1; i++) {
			Cut curr = SDiff.poll();
			total -= curr.diff;
		}
		
		
		System.out.println(total);
	}
	
	

}