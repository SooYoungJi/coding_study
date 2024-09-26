import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int E;
        int T;

        public Node(int E, int T){
            this.E = E;
            this.T = T;
        }
    }

    public static int N, M, W;
    public static List<Node>[] road;
    public static int[] dist;
    public static boolean result;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int Tc = Integer.parseInt(br.readLine());
        for(int tt = 1; tt <= Tc; tt++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N+1];
            road = new ArrayList[N+1];

            for (int i = 0; i <= N; i++){
                road[i] = new ArrayList<Node>();
            }

            for (int mc = 0; mc < M; mc++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                road[S].add(new Node(E, T));
                road[E].add(new Node(S, T));
            }

            for (int wc = 0; wc < W; wc++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
//                warmHole[S].add(new Hole(E, -T));
                road[S].add(new Node(E, -T));
            }

            boolean decrease = false;
            for (int i = 1; i <= N; i++){
                if(bellmanFord(i)){
                    decrease = true;
                    sb.append("YES").append("\n");
                    break;
                }
            }

            if(!decrease){
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean bellmanFord(int start){
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        for(int i = 0; i < N; i++){
            update = false;
            for(int j = 1; j <= N; j++){
                for(Node curr: road[j]){
                    if(dist[j] != INF && dist[curr.E] > dist[j]+curr.T){
                        dist[curr.E] = dist[j]+curr.T;
                        update = true;
                    }
                }
            }
            if(!update){
                break;
            }
        }

        if(update){
            for(int i = 1; i <= N; i++){
                for(Node curr: road[i]){
                    if(dist[i] != INF && dist[curr.E] > dist[i]+curr.T){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}