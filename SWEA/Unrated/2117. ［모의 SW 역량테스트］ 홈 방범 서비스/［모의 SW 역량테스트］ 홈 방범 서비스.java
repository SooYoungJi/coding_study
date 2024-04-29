import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 완탐 문제 

public class Solution {
	
	private static int[] cost = {1,1,5,13,25,41,61,85,113,145,181,221,265,313,365,421,481,545,613,685,761,841,925,1013,1105,1201,1301,1405,1513,1625,1741,1861,1985,2113,2245,2381,2521,2665,2813,2965,3121};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 도시 크기 5~20 
			int M = Integer.parseInt(st.nextToken()); // 
			
			List<int[]> home = new ArrayList<int[]>();
			
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				for (int c = 0, index=0; c < N; c++, index+=2) {
					if(s.charAt(index) == '1') {
						home.add(new int[] {r, c});
					}
					
				}
			}
			
			// 모든 좌표 순회, 지정한 좌표~각집까지 거리를 cnt 배열로 계산해두자. 
			// 할 수 있는 K 영역을 모두 검색 : 이익인지(수익-운영비용) 이익이면 최대값 업데이트 
			int temp = home.size()*M;
			int maxCntHome = 0; // 서비를 받을 수 있는 최대 집의 개수 
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					//(r, c) ~ 각 집까지의 거리 : cnt[]로 계산해두자 
					int[] cnt = new int[2*N];
					for (int i = 0; i < home.size(); i++) {
						cnt[Math.abs(home.get(i)[0]-r) + Math.abs(home.get(i)[1]-c) + 1]++;
					}
					int cntHome = 0; // 집 개수 누적 
					for (int K = 0; K < 2*N; K++) {
						if(temp <= cost[K]) break;
						cntHome += cnt[K];
						// 손해가 아니면 최대값을 업데이트 
//						if(cntHome * M >= K*K+(K-1)*(K-1) && maxCntHome < cntHome) {
						if(cntHome * M >= cost[K] && maxCntHome < cntHome) {
							maxCntHome = cntHome;
						}
					}
				}
			}
			
			sb.append(maxCntHome).append("\n");
		}
		System.out.println(sb);
	}

}