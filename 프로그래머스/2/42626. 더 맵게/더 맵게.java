import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });
        for(int i:scoville){
            pq.add(i);
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(curr < K){
                if(!pq.isEmpty()){
                    int next = pq.poll();
                    int mix = curr + next*2;
                    pq.add(mix);
                    cnt++;
                }else return -1;
            }
        }
        return cnt;
    }
}