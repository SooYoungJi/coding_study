import java.io.*;
import java.util.*;

class Solution {
    public static int N;
    public static int cnt;
    public static int T;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        cnt = 0;
        T = target;
        DFS(0, 0, numbers);
        
        return cnt;
    }
    
    public static void DFS(int depth, int total, int[] numbers){
        if(depth == N){
            if(total == T){
                cnt++;
            }
            return;
        }
        
        for(int i = 0; i < 2; i++){
            if(i == 0){
                DFS(depth + 1, total + numbers[depth], numbers);
            }else{
                DFS(depth + 1, total - numbers[depth], numbers);
            }
        }
    }
}