import java.io.*;
import java.util.*;

public class Main {


    public static int V,E;
    public static int[][] Board;
    public static int INF = 100_000_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Board = new int[V+1][V+1];
        for(int i = 1; i <= V; i++){
            Arrays.fill(Board[i], INF);
        }

        int cnt = INF;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            Board[from][to] = length;
        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    Board[i][j] = Math.min(Board[i][j], Board[i][k]+Board[k][j]);
                }
            }
        }

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                cnt = Math.min(Board[i][j]+Board[j][i], cnt);
            }
        }

        System.out.println(cnt == INF ? -1 : cnt);

    }


}