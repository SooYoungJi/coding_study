import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        Stack<Character> cal = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            switch(c){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!cal.isEmpty() && priority(cal.peek()) >= priority(c)){
                        sb.append(cal.pop());
                    }
                    cal.add(c);
                    break;
                case '(':
                    cal.add(c);
                    break;
                case ')':
                    while (!cal.isEmpty() && cal.peek() != '('){
                        sb.append(cal.pop());
                    }
                    cal.pop();
                    break;
                default:
                    sb.append(c);
            }
        }

        while (!cal.isEmpty()){
            sb.append(cal.pop());
        }

        System.out.println(sb);

    }
    public static int priority(char operator){
        if(operator == '(' || operator == ')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }else
            return -1;
    }
}