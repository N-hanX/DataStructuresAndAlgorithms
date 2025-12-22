package study_lc.study4_c;

public class Palindromic_Substrings_647 {
    public static void main(String[] args) {
//        String s = "abc";
//        int result = countSubstrings(s);

        String s = "aaa";
        int result = countSubstrings(s);
        int a = 4;
    }

    public static int countSubstrings(String s) {
        int palindrome_central_index = 0;
        int totalPalindromeCounter = 0;

        while(palindrome_central_index < s.length()){
            totalPalindromeCounter =  totalPalindromeCounter + findNumOfPalindromWhenThisIndexCentral(s, palindrome_central_index) + findNUmOfPalindromeWhenThisIndexCentral_WithRightIndex(s, palindrome_central_index) ;

            palindrome_central_index++;
        }
        return totalPalindromeCounter;
    }

    public static  int findNUmOfPalindromeWhenThisIndexCentral_WithRightIndex(String s, int curr_ind){
        if( curr_ind + 1 < s.length() && s.charAt(curr_ind) == s.charAt(curr_ind + 1)){

        }else{
            return 0;
        }

        int palindromeCounter = 1;
        int leftInd = curr_ind - 1;
        int rightInd = curr_ind + 2;

        while(leftInd >= 0 && rightInd < s.length()){
            if(s.charAt(leftInd) == s.charAt(rightInd)){
                // System.out.println("main ind: " + curr_ind + "&" + curr_ind + 1 + " : " + s.substring(leftInd, rightInd + 1));
                palindromeCounter++;
            }else{
                break;
            }
            leftInd--;
            rightInd++;
        }

        return palindromeCounter;
    }

    public static int findNumOfPalindromWhenThisIndexCentral(String s, int curr_ind){
        int palindromeCounter = 1;

        int leftInd = curr_ind - 1;
        int rightInd = curr_ind + 1;

        while(leftInd >= 0 && leftInd < s.length() && rightInd < s.length() && rightInd >= 0){
            if(s.charAt(leftInd) == s.charAt(rightInd)){
                // System.out.println("main ind: " + curr_ind + ": " +  s.substring(leftInd, rightInd + 1));
                palindromeCounter++;
            }else{
                break;
            }
            leftInd--;
            rightInd++;
        }
        return palindromeCounter;
    }
}
