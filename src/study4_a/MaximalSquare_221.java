package study4_a;

public class MaximalSquare_221 {
    static void main() {
//        // TEST1
//        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        int result = maximalSquare(matrix);
//        int a = 4;

        // TEST2
//        char[][] matrix = new char[][]{{1,1},{1,1}};
//        int result = maximalSquare(matrix);
//        int a = 4;

        // TEST3
//        char[][] matrix = new char[][]{{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
//        int result = maximalSquare(matrix);
//        int a = 4;

        // TEST4
        char[][] matrix = new char[][]{{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}};
        int result = maximalSquare(matrix);
        int a = 4;

        //TEST5
//        char[][] matrix = new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
//        int result = maximalSquare(matrix);
//        int a = 4;
    }

    public static int maximalSquare(char[][] matrix) {
        int global_max = 0;
        int xLen = matrix.length;
        int yLen = matrix[0].length;

        int[][] dp = new int[xLen + 1][yLen + 1];

        for(int i = 0; i < xLen + 1; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j < yLen + 1; j++) {
            dp[0][j] = 0;
        }

        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++) {
                if(matrix[i][j] == '1'){
                    int temp_val = Math.min(dp[i][j], dp[i+1][j]);
                    temp_val = Math.min(temp_val, dp[i][j+1]);
                    dp[i+1][j+1] = temp_val + 1;
                    global_max = Math.max(global_max, dp[i+1][j+1]);
                }
            }
        }

        return global_max * global_max;
    }
}
