import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < completion.length; i++){
            String p = participant[i];
            String c = completion[i];
            
            map.put(p, map.getOrDefault(p, 0)+1);
            map.put(c, map.getOrDefault(c, 0)-1);
        }
        String last = participant[participant.length-1];
        map.put(last, map.getOrDefault(last, 0)+1);
        
        String answer = "";
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                answer = key;
                break;
            }
        }
        return answer;
    }
}