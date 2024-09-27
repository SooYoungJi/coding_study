import java.io.*;
import java.util.*;

public class Main {
    public static int M,N;

    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int count = 0;

    public static int[][] dp;

    public static int[][] board;
    public static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visited = new boolean[M][N];

        dp = new int[M][N];

        for(int r = 0; r < M; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(DFS(0, 0));
    }

    public static int DFS(int r, int c){

        if(r == M-1 && c == N-1){
            return 1;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        dp[r][c] = 0;

        for(int i = 0; i < 4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(inBound(nr, nc) &&  board[r][c] > board[nr][nc]){
                dp[r][c] += DFS(nr, nc);
            }
        }

        return dp[r][c];

    }

    public static boolean inBound(int nr, int nc){
        if(0 <= nr && nr < M && 0 <= nc && nc < N){
            return true;
        }else return false;
    }

    public static void print(){
        for(int r = 0; r < M; r++){
            for(int c = 0; c < N; c++){
                System.out.print(dp[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}