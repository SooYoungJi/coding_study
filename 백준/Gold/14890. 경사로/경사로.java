import java.io.*;
import java.util.*;

public class Main {
    public static int N, L;
    public static int[][] board;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        int total = 0;

        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        // row check
        int dir = 0;
        int temp = 1;
        boolean able = true;
        for (int r = 0; r < N; r++){
            dir = 0;
            able = true;
            temp = 1;
            for (int c = 1; c < N; c++){
                if(dir ==-1 && temp == L){
                    temp = 0;
                    dir = 0;
                }
                if(Math.abs(board[r][c-1]-board[r][c]) > 1 ){
                    able = false;
                    break;
                }else if(board[r][c-1]-board[r][c] == 1){ // down
                    if(dir == -1 && temp < L){
                        able = false;
                        break;
                    }
                    dir = -1;
                    temp = 1;
                }else if(board[r][c-1]-board[r][c] == -1){ // up
                    if(temp < L || dir == -1){
                        able = false;
                        break;
                    }
                    temp = 1;
                }
                else if(board[r][c-1] == board[r][c]){
                    temp+=1;
                }
            }

            if(dir == -1 && temp < L){
                able = false;
            }
//            System.out.println(able);
            if (able){
                total++;
            }
        }
        // System.out.println("==================");

        // col check
        for (int c = 0; c < N; c++){
            dir = 0;
            able = true;
            temp = 1;
            for (int r = 1; r < N; r++){
                if(dir ==-1 && temp == L){
                    temp = 0;
                    dir = 0;
                }
                if(Math.abs(board[r-1][c]-board[r][c]) > 1 ){
                    able = false;
                    break;
                }else if(board[r-1][c]-board[r][c] == 1){ // down
                    if(dir == -1 && temp < L){
                        able = false;
                        break;
                    }
                    dir = -1;
                    temp = 1;
                }else if(board[r-1][c]-board[r][c] == -1){ // up
                    if(temp < L || dir == -1){
                        able = false;
                        break;
                    }
                    temp = 1;
                }else if(board[r-1][c]==board[r][c]){
                    temp+=1;
                }
            }

            if(dir == -1 && temp < L){
                able = false;
            }
//            System.out.println(able);
            if (able){
                total++;
            }
        }
        System.out.println(total);
    }

}