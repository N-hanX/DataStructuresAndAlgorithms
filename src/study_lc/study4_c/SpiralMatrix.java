package study_lc.study4_c;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

        //[[1,2,3],[4,5,6],[7,8,9]]
//        [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    }
    static int[][] visited_cells;
    public List<Integer> spiralOrder(int[][] matrix) {
        int row_len = matrix.length;
        int col_len = matrix[0].length;

        visited_cells = new int[row_len][col_len];

        List<Integer> elements = new ArrayList<>();

        traverseMatrix(0, 0, 0, matrix, elements);

        return elements;
    }

    public void traverseMatrix(int direction, int startRowInd, int startColInd, int[][] matrix, List<Integer> elements){
        int colLen = matrix[0].length;
        int rowLen = matrix.length;

        // System.out.println("direction:" + direction);
        // System.out.println("startRowInd:" + startRowInd);
        // System.out.println("startColInd:" + startColInd);
        // System.out.println("elem size:" + elements.size());
        if(!elements.isEmpty() && elements.size() == colLen * rowLen){
            return;
        }

        if(direction == 0){ // traverse left to right column in a row
            int the_last_col = startColInd;
            for(int i = startColInd; i < matrix[0].length; i++){
                if(visited_cells[startRowInd][i] == 0){
                    visited_cells[startRowInd][i] = 1;
                    elements.add(matrix[startRowInd][i]);
                    the_last_col = i;
                }else{
                    // System.out.println("break:" + i);
                    break;
                }
            }
            traverseMatrix(1, startRowInd + 1, the_last_col, matrix, elements);
        }else if(direction == 1){ // traverse from upper to lower rows in a col
            int the_last_row = startRowInd;
            for(int i = startRowInd; i < matrix.length; i++){
                if(visited_cells[i][startColInd] == 0){
                    visited_cells[i][startColInd] = 1;
                    elements.add(matrix[i][startColInd]);
                    the_last_row = i;
                }else{
                    break;
                }
            }
            traverseMatrix(2, the_last_row, startColInd - 1, matrix, elements);
        }else if(direction == 2){ // traverse right to left columns in a row
            int the_last_col = startColInd;
            for(int i = startColInd; i >= 0; i--){
                if(visited_cells[startRowInd][i] == 0){
                    visited_cells[startRowInd][i] = 1;
                    elements.add(matrix[startRowInd][i]);
                    the_last_col = i;
                }else{
                    break;
                }
            }
            traverseMatrix(3, startRowInd - 1, the_last_col, matrix, elements);
        }else if(direction == 3){ // traverse from lower to upper rows in a col
            int the_last_row = startRowInd;
            for(int i = startRowInd; i >= 0; i--){
                if(visited_cells[i][startColInd] == 0){
                    visited_cells[i][startColInd] = 1;
                    elements.add(matrix[i][startColInd]);
                    the_last_row = i;
                }else{
                    break;
                }
            }
            traverseMatrix(0, the_last_row, startColInd + 1, matrix, elements);
        }
    }
}
