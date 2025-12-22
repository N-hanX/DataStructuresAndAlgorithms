package study_lc.study4_c;

public class UniquePathsII_63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};

        int result = uniquePathsWithObstacles(obstacleGrid);
        int a = 4;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;

        int[][] dp = new int[rowLen][colLen];

        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }

                if( i == 0 && j == 0){
                    dp[i][j] = 1;
                }else  if( i == 0 && j > 0){
                    dp[i][j] = dp[i][j - 1];
                }else  if(j == 0 && i > 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rowLen - 1][colLen - 1];
    }
}
