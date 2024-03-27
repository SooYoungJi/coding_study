import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("../ws0327/res/inputSWEA3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] array = new int[N];
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList<Integer>();
			
			list.add(array[0]);
			
			for (int i = 1; i < N; i++) {
				if(list.get(list.size()-1) < array[i])
					list.add(array[i]);
				else {
					int idx = binarySearch(0, list.size()-1, array[i]);
					list.set(idx, array[i]);					
				}
			}
			
			sb.append(list.size());
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static int binarySearch(int left, int right, int target) {
		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			if(list.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

}