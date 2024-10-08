import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] height;
    public static int count;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        height = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            height[from][to] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(height[i][k] == 1 && height[k][j] == 1){
                        height[i][j] = 1;
                    }
                }
            }
        }

        int[] cnt = new int[N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(height[i][j] == 1 || height[j][i] == 1){
                    cnt[i]++;
                }
            }
        }

        count = 0;
        for(int i = 1; i <= N; i++){
            if(cnt[i] == N-1){
                count++;
            }
        }

        System.out.println(count);

    }



}