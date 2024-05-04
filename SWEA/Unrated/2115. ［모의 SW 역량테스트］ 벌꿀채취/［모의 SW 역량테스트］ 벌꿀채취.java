import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] beeHouse;
	static int[][] memo;
	static int N, M, C;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			beeHouse = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					beeHouse[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			memo = new int[N][N-M+1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N-M; j++) {
					getHoney(i, j, 0, 0, 0);					
				}
			}
			
			// 어느 위치에서 연속된 M를 추출할지 결정, (일꾼 2명) 100칸 벌통 100C2, 반복문 순회하면서 완탐 
			// 연속된 M칸의 꿀 중 최대 수익을 위해 어느 꿀을 취할 지( 합이 C 이하여야함) 0-1 배낭문제 (완탐-부분집합, DP)
			
			int maxTotalVal = 0;
			for (int r1 = 0; r1 < N; r1++) {
				for (int c1 = 0; c1 <= N-M; c1++) { // 1번 일꾼의 시작 위치 (r1, c1)
					for (int c2 = c1+M; c2 < N-M; c2++) { // 2번 일꾼의 시작 위치 (r1, c2), 1번과 같은 행 
						int totalVal = memo[r1][c1] + memo[r1][c2];
						if(maxTotalVal < totalVal) maxTotalVal = totalVal;
					}
					for (int r2 = r1+1; r2 < N; r2++) {
						for (int c2 = 0; c2 <= N-M; c2++) { // 2번 일꾼의 시작 위치 (r2, c2), 1번과 다른 행 
							int totalVal = memo[r1][c1] + memo[r2][c2];
							if(maxTotalVal < totalVal) maxTotalVal = totalVal;
							
						}
					}
				}
			}
			sb.append(maxTotalVal).append("\n");
		}
		System.out.println(sb);
	}

	/** (r, c) 위치에서 연속 M 칸 영역에서 얻을 수 있는 최대 이익 업데이트 하는 메서드 
	 *  index: M 칸중에 몇번째 칸을 고려할 것인지, sum : 지금까지 선택한 꿀의 합, val : 지금까지 수확한 꿀 수익 */
	private static void getHoney(int r, int c, int index, int sum, int val) {
		if(sum > C) return;
		if(index == M) { //최대값 업데이트
			if(memo[r][c] < val) memo[r][c] = val;
			return;
		}
		int temp = beeHouse[r][c+index];
		getHoney(r, c, index+1, sum+temp, val+temp*temp); // 현재 꿀을 선택 
		getHoney(r, c, index+1, sum, val); // 현재 꿀을 비선택 
	}

}