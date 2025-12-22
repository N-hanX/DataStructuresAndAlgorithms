package study_program.lectureNotes.stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String test1 = "/home/";
        String test2 = "/../";
        String test3 = "/home//foo/";
        String test4 = "/home//foo/.../..";
        String test5 = "/a/./b/../../c/";

        String result = simplifyPath(test4);
        int a = 4;
    }

    public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> direcs_and_backs = new Stack<>();

        for(int i = 0; i < strs.length; i++){
            String str = strs[i];

            if(str.equals("") || str.equals("."))
               continue;
            else if(str.equals("..")){
                if(!direcs_and_backs.empty())
                    direcs_and_backs.pop();
            }
            else
                direcs_and_backs.push(str);
        }

        StringBuilder simplified_path = new StringBuilder();

        for(int i = 0; i < direcs_and_backs.size(); i++){
            simplified_path.append("/");
            simplified_path.append(direcs_and_backs.get(i));
        }

        String result = simplified_path.toString();

        if(result.equals(""))
            result = "/";

        return result;
    }
}
