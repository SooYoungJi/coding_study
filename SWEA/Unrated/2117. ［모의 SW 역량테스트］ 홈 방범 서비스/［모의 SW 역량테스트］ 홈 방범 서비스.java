import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[N][N];
			List<int[]> home = new ArrayList<>();
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					if(board[r][c] == 1) {
						home.add(new int[] {r, c});
					}
				}
			}
			
//			int maxService = home.size()*M;
			int maxHome = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int[] K = new int[N*2+1];
					for(int[] curr : home) {
						K[Math.abs(curr[0]-r)+Math.abs(curr[1]-c)+1]++;
					}
					
					int cnt = 0;
					for (int i = 1; i < N*2+1; i++) {
						cnt += K[i];
						if(cnt*M >= i*i+(i-1)*(i-1) && maxHome < cnt) {
							maxHome = cnt;
						}
					}
				}
			}
			
			sb.append(maxHome).append("\n");
		}
		System.out.println(sb);
	}
}