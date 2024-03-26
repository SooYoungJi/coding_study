import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] knapsack = new int[N+1][K+1];
		
		for (int i = 0; i < N+1; i++) {
			knapsack[i][0] = 0;
		}
		for (int i = 0; i < K+1; i++) {
			knapsack[0][i] = 0;
		}
		
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			for(int wi = 1; wi < K+1; wi++) {
				if(W > wi) {
					knapsack[i][wi] = knapsack[i-1][wi];
				}
				else {
					knapsack[i][wi] = Math.max(V+knapsack[i-1][wi-W], knapsack[i-1][wi]);
				}
			}
		}
		System.out.println(knapsack[N][K]);
	}

}