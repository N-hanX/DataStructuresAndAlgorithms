package study_lc.study4_i;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7}, {15,14,12,16}};
        rotate(matrix);
        int a = 4;
    }

    public static void rotate(int[][] matrix) {
        int edge_size = matrix.length;
        int[][] visited = new int[matrix.length][matrix[0].length];

        for(int row_ind = 0; row_ind < edge_size; row_ind++){
            for(int col_ind = 0; col_ind < edge_size; col_ind++){
                if(visited[row_ind][col_ind] == 0){
                    helper(matrix, visited, col_ind, Math.abs(row_ind - (matrix.length - 1)), matrix[row_ind][col_ind]);
                }
            }
        }
    }

    public static void helper(int[][] matrix, int[][] visited, int rowInd, int colInd, int the_next_value){
        if(visited[rowInd][colInd] == 1){
            return;
        }

        visited[rowInd][colInd] = 1;
        int next_value_assignment = matrix[rowInd][colInd];
        matrix[rowInd][colInd] = the_next_value;
        helper(matrix, visited, colInd, Math.abs(rowInd - (matrix.length - 1)), next_value_assignment);
    }
}
