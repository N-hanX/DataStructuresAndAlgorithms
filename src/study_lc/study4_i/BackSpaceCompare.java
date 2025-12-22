package study_lc.study4_i;

import java.util.Stack;

public class BackSpaceCompare {
    public static void main(String[] args) {
//s = "ab#c", t = "ad#c"
        String s = "ab#c";
        String t = "ad#cm";

        boolean result = backspaceCompare(s, t);
        int a = 4;
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack_s = new Stack<>();
        Stack<Character> stack_t = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '#' && !stack_s.isEmpty()){
                stack_s.pop();
            }else if(c == '#' && stack_s.empty())
                continue;
            else
                stack_s.add(c);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);

            if(c == '#' && !stack_t.isEmpty()){
                stack_t.pop();
            }else if(c == '#' && stack_t.empty())
                continue;
            else
                stack_t.add(c);
        }

        while(!stack_s.isEmpty() && !stack_t.isEmpty()){
            if(stack_s.pop() == stack_t.pop()){
                continue;
            }else{
                return false;
            }
        }

        if(stack_s.isEmpty() && stack_t.isEmpty())
            return true;

        return false;
    }
}
