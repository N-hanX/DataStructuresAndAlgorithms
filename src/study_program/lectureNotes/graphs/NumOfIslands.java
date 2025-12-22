package study_program.lectureNotes.graphs;

public class NumOfIslands {
    public static void main(String[] args) {
//        char[][] grid = new char[][]{ {'1','1','1','1','0'},
//                                      {'1','1','0','1','0'},
//                                      {'1','1','0','0','0'},
//                                      {'0','0','0','0','0'}};
//
//        int numOfIslands = numIslands(grid);

        char[][] grid = new char[][]{ {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};

        int numOfIslands = numIslands(grid);

        int a = 4;
    }

    public static int numIslands(char[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int numOfComponent = 0;

        for(int rowInd = 0; rowInd < rowSize; rowInd++){
            for(int colInd = 0; colInd < colSize; colInd++){
                char currChar = grid[rowInd][colInd];
                if(currChar == '1') {
                    numOfComponent++;
                    dfs(grid, rowInd, colInd);
                }
                if(currChar == '0' || currChar == '2' || currChar == '3')
                    continue;
            }
        }
        return numOfComponent;
    }

    public static void dfs(char[][] grid, int currRow, int currCol){
        int rowSize = grid.length;
        int colSize = grid[0].length;

        if(currRow < 0 || currCol < 0 || rowSize <= currRow || colSize <= currCol){
            return;
        }

        char currChar = grid[currRow][currCol];

        if(currChar == '2') // bu demekki onceden 1 olan deger ziyaret edilmis.
            return;

        if(currChar == '3') // bu demekki onceden 0 olan deger ziyaret edilmis.
            return;

        if(currChar == '1')
            grid[currRow][currCol] = '2';

        if(currChar == '0') {
            grid[currRow][currCol] = '3';
            return;
        }

        dfs(grid, currRow - 1, currCol);
        dfs(grid, currRow + 1, currCol);
        dfs(grid, currRow, currCol - 1);
        dfs(grid, currRow, currCol + 1);
    }
}
