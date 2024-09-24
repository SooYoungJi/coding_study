import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] P;
    public static List<Integer>[] Party;
    public static int parentTrue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        make(N);
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] knowTruth = new int[t];
        parentTrue = 0;

        if(t == 0){
            System.out.println(M);
            System.exit(0);
        }else {
            for(int i = 0; i < t; i++){
                knowTruth[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < t-1; i++){
                union(knowTruth[i], knowTruth[i+1]);
            }
            parentTrue = knowTruth[0];
        }

        Party = new ArrayList[M];
        for(int i = 0; i < M; i++){
            Party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int paritipans = Integer.parseInt((st.nextToken()));
            for(int j = 0; j < paritipans; j++){
                Party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < Party[i].size()-1; j++){
                union(Party[i].get(j), Party[i].get(j+1));
            }
        }

        int cnt = 0;
        for(int i = 0; i < M; i++){
            boolean flag = false;
            for(int j = 0; j < Party[i].size(); j++){
                if(find(Party[i].get(j)) == parentTrue){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void make(int x){
        P = new int[x+1];
        for(int i = 0; i < x+1; i++){
            P[i] = i;
        }
    }

    public static int find(int x){
        if(x == P[x])
            return x;
        else return P[x] = find(P[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
           if(x == parentTrue){
               P[y] = x;
           }else if(y == parentTrue){
               P[x] = y;
           }else{
               P[y] = x;
           }
        }
    }
}