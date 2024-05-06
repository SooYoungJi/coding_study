import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] board;
	static List<int[]> chicken;
	static List<int[]> house;
	static int[] chickPick;
	static int[] chickLen;
	static int chickSize, minChickRoad;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		chicken = new ArrayList<int[]>();
		house = new ArrayList<int[]>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if(board[r][c] == 2) {
					chicken.add(new int[] {r, c});
				} else if(board[r][c] == 1) {
					house.add(new int[] {r, c});
				}
			}
		}
		
		chickSize = chicken.size();
		chickPick = new int[chickSize];
		chickLen = new int[house.size()];
		minChickRoad = Integer.MAX_VALUE;
		
		chickenRoad(0, 0);
		
		System.out.println(minChickRoad);
		
	}
	
	public static void chickenRoad(int start, int cnt) {
		if(cnt == M) {
			// 치킨 가게 리스트 별로 거리 계산 
			Arrays.fill(chickLen, Integer.MAX_VALUE);
			for (int i = 0; i < chickSize; i++) {
				if(chickPick[i] == 1) {
					chickLength(chicken.get(i));
				}
			}
			// min값 갱신
			int temp = 0;
			for(int i = 0; i < chickLen.length; i++) {
				if(chickLen[i] < Integer.MAX_VALUE) {
					temp += chickLen[i];
				}
			}
			minChickRoad = Math.min(minChickRoad, temp);
			return;
		}
		
		for (int i = start; i < chickSize; i++) {
			chickPick[i] = 1;
			chickenRoad(i+1, cnt+1);
			chickPick[i] = 0;
		}
	}
	
	public static void chickLength(int[] c) {
		for (int i = 0; i < house.size(); i++) {
			int len = Math.abs(house.get(i)[0]-c[0]) + Math.abs(house.get(i)[1]-c[1]);
			chickLen[i] = Math.min(chickLen[i], len);
		}
		
	}
}