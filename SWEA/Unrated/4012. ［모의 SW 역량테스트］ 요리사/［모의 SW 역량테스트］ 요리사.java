import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] syn; // 시너지 보드
	static int N; // 식재료의 갯수
	static int[] selected;
	static int[] numbers;
	static List<int[]> combis;
	static int min;
	static List<int[][]> allCombi;
	static int index;
	static int[] numbersOfTwo = new int[2];
	static int syn1;
	static int syn2;
	
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/SWEA4012_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 식재료의 갯수
			min = 40_000;
			// 시너지 보드 초기화
			syn = new int[N][N]; 
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					syn[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//=====초기 세팅 완료=========================================
			
			// 조합 생성
			selected = new int[N+1];
			numbers = new int[N+1];
			allCombi = new ArrayList<>();
			combi(0, 1);
			
			for (int[][] c: allCombi) {
				int minus = 0;
				syn1 = 0;
				combiOfTwo(0, 0, c[0]);
				minus += syn1;
				syn1 = 0;
				combiOfTwo(0, 0, c[1]);
				minus-=syn1;
				min = Math.min(Math.abs(minus), min);
			}
			
			sb.append(min).append("\n");
			
		}
		System.out.println(sb);
	}
	
	public static void combi(int cnt, int start) {
		//기저 조건
		if(cnt == N/2) {
			int index1 = 0;
			int index2 = 0;
			int[] combi1 = new int[N/2];
			int[] combi2 = new int[N/2];
			for (int i = 1; i <= N; i++) {
				if(selected[i] == 1) combi1[index1++] = i;
				else combi2[index2++] = i;
			}
			allCombi.add(new int[][]{combi1, combi2});
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			selected[i] = 1;
			combi(cnt+1, i+1);
			selected[i] = 0;
			
		}
	}
	
	public static void combiOfTwo(int cnt, int start, int[] combinations) {
		if(cnt == 2) {
			syn1 += synergy(numbersOfTwo);
			return;
		}
		
		for(int i = start; i < combinations.length; i++) {
			numbersOfTwo[cnt] = combinations[i];
			combiOfTwo(cnt+1, i+1, combinations);
		}
	}

	private static int synergy(int[] combi) {
		return syn[combi[0]-1][combi[1]-1] + syn[combi[1]-1][combi[0]-1];
	}
	
}