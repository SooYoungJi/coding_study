import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] opers; //연산자 '+', '-', '*', '/' 순서
	static int[] numbers; //숫자
	static int Min, Max;
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = null;
		 StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			//@@ TODO: 입력으로 주어진 연산자를 목적에 맞게 입력 받으세요
			opers = new int[4];
			for (int i = 0; i < 4; i++) {
				opers[i] = Integer.parseInt(st.nextToken());
			}
			//연산에 활용할 숫자 정보
			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N;i++) {
				numbers[i]=Integer.parseInt(st.nextToken());
			}
			
			//--------------INPUT END-------------------------
			//테스트 케이스 별로 값이 유지 되기 때문에 초기화 필수
			Min =Integer.MAX_VALUE;
			Max = Integer.MIN_VALUE;
			//@@ TODO : 연산자 순열을 만들어서, 수식을 완성시켜 보세요.
			makePer(new int[N-1], 0);
			
			sb.append(Max-Min).append("\n");
			
		}
		System.out.println(sb);

	}
	
	/**
	 * @TODO : 연산자 순열 만들기
	 */
	static void makePer(int[] operSelect, int cnt) {
		if(cnt == N-1) {
			int result = calc(operSelect);
			Min = Math.min(Min, result);
			Max = Math.max(Max, result);
		}
		for (int i = 0; i < 4; i++) {
			if(opers[i] > 0) {
				operSelect[cnt] = i;
				opers[i]--;
				makePer(operSelect, cnt+1);
				opers[i]++;
			}
		}
	}
	
	/**
	 * @TODO : 연산식 계산하기
	 * @return
	 */
	static int calc(int[] operSelect) {
		int num = numbers[0];
		for (int i = 0; i < operSelect.length; i++) {
			int oper = operSelect[i];
			if(oper==0) {
				num += numbers[i+1];
			}else if(oper == 1) {
				num -= numbers[i+1];
			}else if(oper == 2) {
				num *= numbers[i+1];
			}else if(oper == 3) {
				num /= numbers[i+1];
			}
		}
		
		return num;
	}
}