import java.io.*;
import java.util.*;

public class Main {
    public static class Work implements Comparable<Work> {
        int day;
        int point;

        public Work(int day, int point) {
            this.day = day;
            this.point = point;
        }

        @Override
        public int compareTo(Work o) {
            return o.point - this.point;
        }
    }

    public static PriorityQueue<Work> homework;
    public static int N;
    public static int maxPoint;
    public static int[] solved;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        homework = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            homework.add(new Work(d, w));
        }

        maxPoint = 0;
        solved = new int[N+1];
        while (!homework.isEmpty()){
            Work w = homework.poll();
            if(w.day > N){
                for(int i = N; i > 0; i--){
                    if(w.point > solved[i]){
                        solved[i] = w.point;
                        break;
                    }
                }
            }else if(w.point > solved[w.day]){
                solved[w.day] = w.point;
            }else{
                for(int i = w.day; i > 0; i--){
                    if(w.point > solved[i]){
                        solved[i] = w.point;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i <= N; i++){
//            System.out.println(solved[i]);
            maxPoint += solved[i];
        }
        System.out.println(maxPoint);
    }

}