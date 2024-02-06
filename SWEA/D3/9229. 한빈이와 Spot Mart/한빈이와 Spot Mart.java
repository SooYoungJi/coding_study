import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/SWEA9229_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] bag = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				bag[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(bag);
			int front = 0;
			int back = N-1;
			int min = M;
			int max = -1;
			while(front<back || bag[back]+bag[front] != M) {
				
				if(bag[back]+bag[front] <= M && min > M-bag[back]-bag[front]) {
					min = M-bag[back]-bag[front];
					max = bag[back]+bag[front];
				}
				
				if(back-1 >= 0 && bag[back]+bag[front] > M) back--;
				else if(front+1 < N && bag[back]+bag[front] < M) front++;
				else {
					back--;
					front++;
				}
				if(back == front) break;
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}