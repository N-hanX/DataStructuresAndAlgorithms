package study_lc.study4_c;

public class LongestPalindromicSubsequence_516_betterSolution {
    // not my solution, leetcode //
    public static void main(String[] args) {
//                String s = "bbbab";
//        String s= "cbbd";
        String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        int result = longestPalindromeSubseq(s);
        int a = 8;
    }

    public static int longestPalindromeSubseq(String s){
        int n = s.length();
        int[][] memo = new int[n][n];
        int result = lps(s, 0, n - 1, memo);
        return result;
    }
    public static int lps(String s, int i, int j, int[][] memo){
        if(memo[i][j] != 0){
            return memo[i][j];
        }

        if(i > j){
            return 0;
        }

        if(i == j){
            return 1;
        }

        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = lps(s, i + 1, j - 1, memo) + 2;
        }else{
            memo[i][j] = Math.max(lps(s, i + 1, j, memo), lps(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}
