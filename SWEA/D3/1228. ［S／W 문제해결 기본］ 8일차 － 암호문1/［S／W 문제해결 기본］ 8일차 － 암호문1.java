import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	private static LinkedList<String> original;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/SWEA1228_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 개수 
			original = new LinkedList<>();
			st = new StringTokenizer(br.readLine()); // 원본 암호문 뭉치를 token으로 쪼개도록 넣기 
			
			for (int i = 0; i < N; i++) {
				original.add(st.nextToken());				
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				if(st.nextToken().charAt(0) == 'I') {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for (int j = idx; j < idx+num; j++) {
						original.add(j, st.nextToken());
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(original.get(i)).append(" ");
			}
			sb.append("\n");
			original.clear();
		}
		System.out.println(sb);
	}

}