import java.io.*;
import java.util.*;

class Solution {
    public static int[] dr = {0, 0, -1, 1};
    public static int[] dc = {-1, 1, 0, 0};
    public static int[][] Map;
    public static int N;
    public static int M;
    public static int minCnt = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        Map = new int[N][M];
        
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                Map[r][c] = maps[r][c];
            }
        }
        Map[0][0] = 2;
        BFS(0, 0, 1);
        return minCnt == Integer.MAX_VALUE? -1 : minCnt;
    }
    public static void BFS(int r, int c, int cnt){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c, cnt});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            // print();
            for(int i = 0; i < 4; i++){
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if(inBound(nr, nc) && Map[nr][nc] == 1){
                    Map[nr][nc] = 2;
                    if(nr == N-1 && nc == M-1){
                        minCnt = Math.min(minCnt, curr[2]+1);
                    }else{
                        queue.add(new int[] {nr, nc, curr[2]+1}); 
                    }
                }
            }
        }
    }
    public static boolean inBound(int nr, int nc){
        if(0 <= nr && nr < N && 0 <= nc && nc < M){
            return true;
        }else{
            return false;
        }
    }
    public static void print(){
        for(int r = 0; r < M; r++){
            for(int c = 0; c < N; c++){
                System.out.print(Map[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}