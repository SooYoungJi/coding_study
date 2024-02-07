import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int first = Integer.parseInt(br.readLine());
		String second = br.readLine();
		char[] chars = second.toCharArray();
		for (int i = 2; i>=0; i--) {
			sb.append(first*(chars[i]-'0')).append("\n");			
		}
		sb.append(first*Integer.parseInt(second));
		System.out.println(sb);
	}

}