import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            String answer = "";
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] chars = st.nextToken().toCharArray();
            for(char c : chars){
                for(int i = 0; i < n; i++){
                    answer += Character.toString(c);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}