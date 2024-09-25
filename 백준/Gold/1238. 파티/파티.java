import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int to;
        int time;
        public Node(int to, int time){
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return this.time - o.time;

        }
    }

    public static List<Node>[] road;
    public static List<Node>[] r_road;

    public static int[] dist;
    public static int[] r_dist;

    public static int N;
    public static int M;
    public static int X;




    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        road = new ArrayList[N+1];
        r_road = new ArrayList[N+1];

        dist = new int[N+1];
        r_dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(r_dist, Integer.MAX_VALUE);

        for(int i = 0; i < N+1; i++){
            road[i] = new ArrayList<>();
            r_road[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            road[from].add(new Node(to, time));
            r_road[to].add(new Node(from, time));
        }


        dijkstra(X, dist, road);
        dijkstra(X, r_dist, r_road);

        int maxTime = 0;
        for(int i = 1; i <= N; i++){
            maxTime = Math.max(maxTime, dist[i]+r_dist[i]);
        }

        System.out.println(maxTime);
    }

    // 최단 경로 구하는 dijkstra
    public static void dijkstra(int start, int[] dist, List<Node>[] arr){

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            for(Node next: arr[now.to]){
                if(dist[next.to] > dist[now.to] + next.time){
                    dist[next.to] = dist[now.to] + next.time;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

}