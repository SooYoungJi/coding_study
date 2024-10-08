import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] nums;
    public static int[] math; // +, -, *, /
    public static int maxNum = Integer.MIN_VALUE;
    public static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        math = new int[4];
        for(int i = 0; i < 4; i++){
            math[i] = Integer.parseInt(st.nextToken());
        }

        perm(0, nums[0]);
        System.out.println(maxNum);
        System.out.println(minNum);
    }

    // 순열
    public static void perm(int depth, int cal){
        if(depth == N-1){
            // 계산
            maxNum = Math.max(cal, maxNum);
            minNum = Math.min(cal, minNum);
            return;
        }


        for(int i = 0; i < 4; i++){
            if(math[i] > 0){
                math[i] -= 1;
                switch (i){
                    case 0:
                        perm(depth+1, cal+nums[depth+1]);
                        break;
                    case 1:
                        perm(depth+1, cal-nums[depth+1]);
                        break;
                    case 2:
                        perm(depth+1, cal*nums[depth+1]);
                        break;
                    case 3:
                        perm(depth+1, cal/nums[depth+1]);
                        break;
                }
                math[i] += 1;
            }
        }

    }


}