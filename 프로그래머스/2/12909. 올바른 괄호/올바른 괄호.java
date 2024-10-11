import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if(s.charAt(0) == ')') return false;
        
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            
            if(curr == '('){
                stack.push("(");
            }else{
                if(!stack.isEmpty() && stack.peek() == "("){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        
        if(!stack.isEmpty()) return false;
        return answer;
    }
}