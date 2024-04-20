import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] dict;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		dict = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			dict[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(dict);
		
		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(target, 0, N-1)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int binarySearch(int target, int start, int end) {
		int mid;
		
		if(start <= end) {
			mid = start+(end-start)/2;
			if(target == dict[mid]) {
				return 1;
			} else if(target < dict[mid]) {
				return binarySearch(target, start, mid-1);
			} else {
				return binarySearch(target, mid+1, end);
			}
		}
		return 0;
	}
}