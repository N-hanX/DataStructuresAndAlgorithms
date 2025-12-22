package study_lc;

public class SearchA2DMatrixII {
    public static void main(String[] args) {
//{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}

        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 20; // 5, 20

        boolean result = searchMatrix(matrix, target);
        int a = 4;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            if(binarySearch(matrix, target, i, 0, matrix[0].length - 1))
                return true;
        }
        return false;
    }


    public static boolean binarySearch(int[][] matrix, int target, int x_constant, int startY, int endY){
        if(startY < 0 || endY < 0 || startY >= matrix[0].length || endY >= matrix[0].length || startY > endY){
            return false;
        }

        int middleY = (endY - startY) / 2 + startY;

        if(matrix[x_constant][middleY] == target){
            return true;
        }

        if(matrix[x_constant][middleY] > target){
            if(binarySearch(matrix, target, x_constant, startY, middleY - 1)){
                return true;
            }
        }else{
            if(binarySearch(matrix, target, x_constant, middleY +  1, endY)) {
                return true;
            }
        }
        return false;
    }
}
