package study_lc;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";

        String result = longestPalindrome(s);
        int a = 4;
    }

    public static String longestPalindrome(String s){
        String theMaxPalindrome = null;

        for(int leftStart = 0; leftStart < s.length(); leftStart++){
            for(int rightEnd = leftStart; rightEnd < s.length(); rightEnd++){
                if(theMaxPalindrome != null && rightEnd - leftStart + 1 > theMaxPalindrome.length()){
                    if(isPalindromic(s, leftStart, rightEnd)){
                        theMaxPalindrome = s.substring(leftStart, rightEnd + 1);
                    }
                }
                if(theMaxPalindrome == null){
                    theMaxPalindrome = s.substring(leftStart, rightEnd + 1);
                }
            }
        }
        return theMaxPalindrome;
    }

    public static boolean isPalindromic(String s, int leftStart, int rightEnd){
        while(leftStart < rightEnd && s.charAt(leftStart) == s.charAt(rightEnd)){
            leftStart++;
            rightEnd--;
            if(leftStart >= rightEnd){
                return true;
            }
        }
        return false;
    }
}
