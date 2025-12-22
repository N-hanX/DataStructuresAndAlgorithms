package study_program.problemSet.graph;

import java.util.*;

public class KnightsTourOnAChessboard {
    public static void main(String[] args) {
//        {
//            "rows": 5,
//                "cols": 5,
//                "start_row": 0,
//                "start_col": 0,
//                "end_row": 4,
//                "end_col": 1
//        }
//        int rows = 5;
//        int cols = 5;
//        int start_row = 0;
//        int start_col = 0;
//        int end_row = 4;
//        int end_col = 1;

        int rows = 2;
        int cols = 1;
        int start_row = 1;
        int start_col = 0;
        int end_row = 0;
        int end_col = 0;

        Integer result = find_minimum_number_of_moves(rows, cols, start_row, start_col, end_row, end_col);

    }
    static class MoveLocation{
        int row;
        int col;
        public MoveLocation(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            MoveLocation obj = (MoveLocation)o;
            if(obj.row == this.row && obj.col == this.col){
                return true;
            }
            return false;
        }
    }


    static Integer find_minimum_number_of_moves(Integer rows, Integer cols, Integer start_row, Integer start_col, Integer end_row, Integer end_col) {
        int[][] chess = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                chess[i][j] = -1;
            }
        }

        chess[start_row][start_col] = 0;
        Set<MoveLocation> moveList = new HashSet<>();
        MoveLocation location = new MoveLocation(start_row, start_col);
        moveList.add(location);

        int moveCounter = 1;
        while(true){
            Iterator<MoveLocation> locationIterator = moveList.iterator();
            Set<MoveLocation> newList = new HashSet<>();

            if(moveList.isEmpty()){
                return -1;
            }

            while(locationIterator.hasNext()){
                MoveLocation currLocation = locationIterator.next();

                if(currLocation.row == end_row && currLocation.col == end_col){
                    return chess[end_row][end_col];
                }

                fillTheMoves(chess, currLocation.row, currLocation.col, moveCounter, newList, rows, cols);
            }
            moveCounter++;
            moveList = newList;
        }

    }

    static void fillTheMoves(int[][] chess, Integer row, Integer col, Integer move, Set<MoveLocation> newLocation,
                             Integer rows, Integer cols){
        chessFiller(chess, row + 2, col + 1, move, newLocation, rows, cols);
        chessFiller(chess, row + 2, col - 1, move, newLocation, rows, cols);
        chessFiller(chess, row - 2, col + 1, move, newLocation, rows, cols);
        chessFiller(chess, row - 2, col - 1, move, newLocation, rows, cols);

        chessFiller(chess, row + 1, col + 2, move, newLocation, rows, cols);
        chessFiller(chess, row + 1, col - 2, move, newLocation, rows, cols);
        chessFiller(chess, row - 1, col + 2, move, newLocation, rows, cols);
        chessFiller(chess, row - 1, col - 2, move, newLocation, rows, cols);

    }

    static void chessFiller(int[][] chess, Integer row, Integer col, Integer move, Set<MoveLocation> newLocation,
                        int rows, int cols){
        if(col >= cols || col < 0 || row >= rows || row < 0 || chess[row][col] != -1){
            return;
        }

        chess[row][col] = move;
        newLocation.add(new MoveLocation(row, col));
    }
}
