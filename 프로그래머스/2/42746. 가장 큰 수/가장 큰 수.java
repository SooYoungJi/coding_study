import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for(int i : numbers){
            list.add(String.valueOf(i));
        }
        
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return Integer.parseInt(s2) - Integer.parseInt(s1);
            }
        });
            
        for(String s : list){
            answer += s;
        }
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}