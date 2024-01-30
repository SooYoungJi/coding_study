import java.io.*;
import java.util.*;

public class Main {
	
	static int switchNum;
	static int[] switches;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		switchNum = Integer.parseInt(br.readLine());
		switches = new int[switchNum];
		
		String[] Lines = br.readLine().split(" ");

		for (int i = 0; i < switchNum; i++) {
			switches[i] = Integer.parseInt(Lines[i]);
		}

		int studentNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < studentNum; i++) {
			String[] student = br.readLine().split(" ");
			
			int num = Integer.parseInt(student[1]);
			
			if (Integer.parseInt(student[0]) == 1) { // boy
				for (int j = 0; j < switchNum; j++) {
					if ((j+1) % num == 0) {
						reverse(j);
					}
				}
			} else { // girl
				num -= 1;
				int t = 1;
				while (num+t < switchNum && num-t >= 0 && switches[num - t] == switches[num + t]) {
						reverse(num - t);
						reverse(num + t);
						t++;
				}
				reverse(num);
			}
		}

		for (int s = 1; s <= switchNum; s++) {
            if (s % 20 == 0) {
                sb.append(switches[s - 1]).append("\n");
                continue;
            }
            sb.append(switches[s - 1]).append(" ");
        }
		
		System.out.println(sb);
	}

	private static void reverse(int j) {
		if (switches[j] == 0) switches[j] = 1;
		else switches[j] = 0;
	}

}