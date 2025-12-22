package study_program.problemSet.string;

public class RegexMatcher {
    public static void main(String[] args) {
//        {
//            "text": "abbbc",
//                "pattern": "ab*c"
//        }

        String text = "abbbc";
        String pattern = "ab*c";

//        {
//            "text": "abcdefg",
//                "pattern": "a.c.*.*gg*"
//        }

//        String text = "abcdefg";
//        String pattern = "a.c.*.*gg*";

//        {
//            "text": "abc",
//                "pattern": ".ab*.."
//        }

//        String text = "abc";
//        String pattern = ".ab*..";

//        Boolean result = pattern_matcher(text, pattern);

        int a = 4;
    }

    // https://www.youtube.com/watch?v=l3hda49XcDE&t=12s
    static Boolean pattern_matcher(char[] text, char[] pattern) {
        boolean table[][] = new boolean[text.length + 1][pattern.length + 1];
        table[0][0] = true;

        for(int i = 1; i < table[0].length; i++){
            if(pattern[i - 1] == '*'){
                table[0][i] = table[0][i - 2];
            }
        }

        for(int i = 1; i < table.length; i++){
            for(int j = 1; j < table[0].length; j++){
                if(pattern[j - 1] == '.' ||  pattern[j - 1] == text[i - 1]){
                    table[i][j] = table[i - 1][j - 1];
                }else if(pattern[j - 1] == '*'){
                    table[i][j] = table[i][j - 2];
                    if(pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]){
                        table[i][j] = table[i][j] || table[i][j - 1];
                    }
                }else{
                    table[i][j] = false;
                }
            }
        }

        return table[text.length][pattern.length];
    }

}
