package graph;

import java.util.ArrayList;
import java.util.List;

public class MaxIslandSize {
    static boolean[][] visited_arr;
    static int currSize;
    static int maxSize;

    public static void main(String[] args) {
        List<List<Integer>> matrix = testExample1();

        if(matrix.size() == 0){
//            return 0;
        }
        int columnSize = matrix.size();
        int rowSize = matrix.get(0).size();
        visited_arr = new boolean[columnSize][rowSize];

        max_island_size(matrix);
        int a = 5;
    }

    public static int max_island_size(List<List<Integer>> grid) {
        // Write your code here
        maxSize = 0;
        for(int columnCount = 0; columnCount < grid.size(); columnCount++){
            for(int rowCount = 0; rowCount < grid.get(0).size(); rowCount++){
                if(!visited_arr[columnCount][rowCount] && grid.get(columnCount).get(rowCount) == 1){
                    currSize = 0;
                    helper(grid, columnCount, rowCount);
                    if(maxSize < currSize){
                        maxSize = currSize;
                    }
                }
            }
        }
        return maxSize;
    }

    public static void helper(List<List<Integer>> matrix, int currCol, int currRow ){
        if(currCol == matrix.size() || currRow == matrix.get(0).size() ||
                currCol < 0 || currRow < 0){
            return;
        }

        if(matrix.get(currCol).get(currRow) == 1 && !visited_arr[currCol][currRow]){
            currSize++;
            visited_arr[currCol][currRow] = true;
            helper(matrix, currCol - 1, currRow);
            helper(matrix, currCol + 1, currRow);
            helper(matrix, currCol, currRow + 1);
            helper(matrix, currCol, currRow - 1);
        }
    }

    public static List<List<Integer>> testExample1(){
        List<List<Integer>> matrix = new ArrayList<>();

        List<Integer> example = new ArrayList<>();
        example.add(1);
        example.add(1);
        example.add(0);
        matrix.add(example);

        List<Integer> example2 = new ArrayList<>();
        example2.add(1);
        example2.add(1);
        example2.add(0);
        matrix.add(example2);

        List<Integer> example3 = new ArrayList<>();
        example3.add(0);
        example3.add(0);
        example3.add(1);
        matrix.add(example3);


        return matrix;
    }
}
