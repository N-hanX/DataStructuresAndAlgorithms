package study_program.lectureNotes.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str1 = "([]){()}[]()[]{()()}]";
        String str2 = "{){(})[()[]{()()";

        boolean result = isValid(str2);
        int a = 4;
    }

    public static boolean isValid(String s) {
        Stack<Character> paranthesis = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                paranthesis.push(c);
            }else if(c == ')' || c == '}' || c == ']') {
                if(!paranthesis.empty()) {
                    char the_peek = paranthesis.peek();
                    if (c == ')' && the_peek != '(') {
                        return false;
                    }
                    if (c == '}' && the_peek != '{') {
                        return false;
                    }
                    if (c == ']' && the_peek != '[') {
                        return false;
                    }
                    paranthesis.pop();
                }else{
                    return false;
                }
            }
        }
        if(!paranthesis.empty())
            return false;
        return true;
    }
}
