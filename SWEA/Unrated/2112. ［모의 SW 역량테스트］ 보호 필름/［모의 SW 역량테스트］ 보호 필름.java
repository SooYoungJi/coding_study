import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int W; // 보호 필름 폭 W
	static int D; // 보호필름 두께 D
	static int K; // 합격기준 K
	static int Min; // 최소 투약 횟수
	static int[][] film; // 필름 정보
	static int[] chemicals;// 약품 투약 정보

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			Min = Integer.MAX_VALUE;
			chemicals = new int[D];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ------------Input End------------------------

			dfs(0, 0);

			sb.append(Min).append("\n");

		}
		System.out.println(sb);
	}

	/**
	 * dfs로 부분집합
	 * 
	 * @param inputCnt : 약품 투여 횟수
	 * @param row      : 약품 주입여부가 적용 될 행
	 */
	static void dfs(int inputCnt, int row) {
		if (inputCnt > K) {
			return;
		}
		if (inputCnt >= Min) {
			return;
		}
		if (row == D) {
			if(check()) {
				Min = Math.min(Min, inputCnt);
			}
			return;
		}

		for (int i = -1; i < 2; i++) {
			chemicals[row] = i;
			if(i == -1) {
				dfs(inputCnt, row+1);
			}else {
				dfs(inputCnt+1, row+1);
			}
		}

	}

	/**
	 * 필름 합격 기준 통과 여부 확인을 위한 메소드
	 * 
	 * @return true : 합격/ false : 불합격
	 */
	static boolean check() {
		int cnt = 0;
		int curr, next;
		for (int col = 0; col < W; col++) {
			cnt = 1;
			for (int row = 0; row < D-1; row++) {
				curr = chemicals[row] == -1 ? film[row][col] : chemicals[row];
				next = chemicals[row+1] == -1 ? film[row+1][col] : chemicals[row+1];
				
				if(curr == next) {
					cnt++;
					if(cnt >= K) {
						break;
					}
				}else {
					cnt = 1;
				}
			}
			if(cnt < K) {
				return false;
			}
		}
		return true;
	}
}