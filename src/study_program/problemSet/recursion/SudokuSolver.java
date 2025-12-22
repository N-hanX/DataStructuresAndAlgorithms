package study_program.problemSet.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
//        [8, 4, 9, 0, 0, 3, 5, 7, 0],
//        [0, 1, 0, 0, 0, 0, 0, 0, 0],
//        [7, 0, 0, 0, 9, 0, 0, 8, 3],
//        [0, 0, 0, 9, 4, 6, 7, 0, 0],
//        [0, 8, 0, 0, 5, 0, 0, 4, 0],
//        [0, 0, 6, 8, 7, 2, 0, 0, 0],
//        [5, 7, 0, 0, 1, 0, 0, 0, 4],
//        [0, 0, 0, 0, 0, 0, 0, 1, 0],
//        [0, 2, 1, 7, 0, 0, 8, 6, 5]

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(8, 4, 9, 0, 0, 3, 5, 7, 0));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(7, 0, 0, 0, 9, 0, 0, 8, 3));

        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(0, 0, 0, 9, 4, 6, 7, 0, 0));
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(0, 8, 0, 0, 5, 0, 0, 4, 0));
        ArrayList<Integer> arr6 = new ArrayList<>(Arrays.asList(0, 0, 6, 8, 7, 2, 0, 0, 0));

        ArrayList<Integer> arr7 = new ArrayList<>(Arrays.asList(5, 7, 0, 0, 1, 0, 0, 0, 4));
        ArrayList<Integer> arr8 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 0));
        ArrayList<Integer> arr9 = new ArrayList<>(Arrays.asList(0, 2, 1, 7, 0, 0, 8, 6, 5));

        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        board.add(arr1);
        board.add(arr2);
        board.add(arr3);

        board.add(arr4);
        board.add(arr5);
        board.add(arr6);

        board.add(arr7);
        board.add(arr8);
        board.add(arr9);

        ArrayList<ArrayList<Integer>> solution = solve_sudoku_puzzle(board);
        int a;
    }


    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        fillSudokuPuzzle(board, result, 0, 0);

        return result;
    }

    static void fillSudokuPuzzle(ArrayList<ArrayList<Integer>> board, ArrayList<ArrayList<Integer>> result,
                                 int row, int col) {
        if(row > 8 || col > 8){
            result.addAll(board);
            return;
        }

        if(board.get(row).get(col) == 0) {
            int digit = 1;
            while (digit < 10) {
                //            System.out.println("r" + curr_row + " c:" + curr_col + " digit " + digit);
                if (isSafe(board, row, col, digit)) {
                    board.get(row).set(col, digit);
                    if (col < 8)
                        fillSudokuPuzzle(board, result, row, col + 1);
                    else
                        fillSudokuPuzzle(board, result, row + 1, 0);

                    if(!result.isEmpty()){
                        return;
                    }

                    board.get(row).set(col, 0);

                }
                digit++;
            }
        }else{
            if (col < 8)
                fillSudokuPuzzle(board, result, row, col + 1);
            else
                fillSudokuPuzzle(board, result, row + 1, 0);
        }

    }

    static boolean isSafe(ArrayList<ArrayList<Integer>> board, int row, int col, int digit){

        // control dikey
        int count = 0;

        while(count < 9){
            if(board.get(count).get(col) == digit){
                return false;
            }
            count++;
        }

        // control yatay

        count = 0;
        while(count < 9){
            if(board.get(row).get(count) == digit){
                return false;
            }
            count++;
        }

        int cell_location_row = row / 3;
        int cell_location_col = col / 3;

        for(int i = cell_location_row * 3; i < (cell_location_row * 3) + 3; i++){
            for(int j = cell_location_col * 3; j < (cell_location_col * 3) + 3; j++){
                if(board.get(i).get(j) == digit){
                    return false;
                }
            }
        }
        return true;
    }
}
