import java.io.*;
import java.util.*;

class Solution {
    public static boolean[] isSelected;
    public static int[][] board;
    public static int N;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        board = new int[n][n];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                board[r][c] = computers[r][c];
            }
        }
        isSelected = new boolean[n];
        int cnt = 0;
        N = n;
        for(int i = 0; i < n; i++){
            if(!isSelected[i]){
                cnt++;
                BFS(i);
            }
            
        }
        return cnt;
    }
    public static void BFS(int start){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        isSelected[start] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0; i < N; i++){
                if(board[curr][i] == 1 && !isSelected[i]){
                    isSelected[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}