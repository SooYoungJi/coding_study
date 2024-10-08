import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        // 1 <= E <= 15
        // 1 <= S <= 28
        // 1 <= M <= 19
        int year = 1;
        while (true){
            if((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0){
                break;
            }
            year++;
        }
        System.out.println(year);
    }
}