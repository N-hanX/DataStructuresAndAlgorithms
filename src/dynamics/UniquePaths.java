package dynamics;

public class UniquePaths {
    public static void main(String[] args) {

    }

    static Integer unique_paths(Integer n, Integer m) {

        int[][] dpTable = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                // 2 tane yol var.
                // 1 tanesi solunadki kolona gelme sayisi digeri ustundeki kolona gelmesa sayisi bunlarin toplami
                if(i == 0 || j == 0)
                    dpTable[i][j] = 1;
                else
                    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - 1];
            }
        }
        return dpTable[n][m];
    }
}
