package study_lc.study4_c;

public class SearchA2DMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        boolean result = searchMatrix(matrix, target);
        int a = 4;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;

        int currRowInd = binarySearchInRow_LookingOnlyLastIndex(matrix, target, 0, numOfRow - 1);
        if(currRowInd >= numOfRow)
            return false;
        int colInd = binarySearchIn_onlyOneRow(matrix, target, currRowInd, 0, numOfCol - 1);

        if(matrix[currRowInd][colInd] == target){
            return true;
        }
        return false;
    }

    public static int binarySearchIn_onlyOneRow(int[][] matrix, int target, int currRowInd, int startColInd, int endColInd){
        if(startColInd > endColInd) {
            return startColInd;
        }
        int middleColInd = (endColInd - startColInd) / 2 + startColInd;

        if(matrix[currRowInd][middleColInd] > target ){
            return binarySearchIn_onlyOneRow(matrix, target, currRowInd, startColInd, middleColInd - 1);
        }else if(matrix[currRowInd][middleColInd] < target ){
            return binarySearchIn_onlyOneRow(matrix, target,  currRowInd, middleColInd + 1, endColInd);
        }else{
            return middleColInd;
        }
    }

    public static int binarySearchInRow_LookingOnlyLastIndex(int[][] matrix, int target, int startRowInd, int endRowInd){
        if(startRowInd > endRowInd){
            return startRowInd;
        }
        int colLen = matrix[0].length - 1;

        int middleRowInd = (endRowInd - startRowInd) / 2 + startRowInd;

        if(matrix[middleRowInd][colLen] > target ){
            return binarySearchInRow_LookingOnlyLastIndex(matrix, target, startRowInd, middleRowInd - 1);
        }else if(matrix[middleRowInd][colLen] < target ){
            return binarySearchInRow_LookingOnlyLastIndex(matrix, target, middleRowInd + 1, endRowInd);
        }else{
            return middleRowInd;
        }
    }
}
