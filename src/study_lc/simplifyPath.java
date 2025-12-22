package study_lc;

import java.util.*;

public class simplifyPath {
    public static void main(String[] args) {
        String str = "/a/./b/../../c/";

        String[] words=str.split("/");

        Stack<String> stack = new Stack<>();

        String theTop;
        for(int i = 0; i < words.length; i++){
            String a = words[i];

            if(a.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(a != "" && !a.equals(".")){
                stack.add(a);
            }
        }

        ArrayList<String> oppositeWords = new ArrayList<>();
        while(!stack.isEmpty()){
            oppositeWords.add(stack.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        for(int i = oppositeWords.size() - 1; i >= 0; i--){
            stringBuilder.append(oppositeWords.get(i));
            if( i != 0){
                stringBuilder.append("/");
            }
        }



//        return stringBuilder.toString();

        int a=  5;
    }
}
