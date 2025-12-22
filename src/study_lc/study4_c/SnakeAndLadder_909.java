package study_lc.study4_c;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadder_909 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int result = snakesAndLadders(board);
        int a = 4;
    }

    public static  int snakesAndLadders(int[][] board) {
        int board_len = board.length;

        int end_index = board_len * board_len;

        int movement = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int queue_size = queue.size();
            movement++;

            for(int i = 0; i < queue_size; i++){
                int curr_index = queue.poll();
                if(visited.contains(curr_index)){
                    continue;
                }
                visited.add(curr_index);
                int dice_count = 1;
                while(dice_count <= 6 ){
                    int next_index = curr_index + dice_count;
                    int next_value = getValue(next_index, board);
                    if(next_value == end_index || next_index == end_index){
                        return movement;
                    }
                    if(next_value == -1){
                        // System.out.println("index: " + next_index);
                        queue.add(next_index);
                    }else{
                        // System.out.println("index: " + next_value);
                        queue.add(next_value);
                    }

                    dice_count++;

                }
            }
        }
        return -1;
    }

    public static int getValue(int curr_index, int[][] board){
        int curr_col_index, curr_row_index;
        curr_col_index = (curr_index - 1) % board.length;
        curr_row_index = (board.length - 1) - (curr_index - 1) / board.length;

        if((board.length % 2 == 1 && curr_row_index % 2 == 1 )||
                (board.length % 2 == 0 && curr_row_index % 2 == 0)){ // count from left to right for column
            curr_col_index = board.length - 1 - curr_col_index;
        }else{ // count from right for column

        }

        // System.out.println("row: " + curr_row_index + " - col: " + curr_col_index);
        return board[curr_row_index][curr_col_index];
    }
}
