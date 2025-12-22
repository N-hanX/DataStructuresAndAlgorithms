package graph;

import java.util.ArrayList;
import java.util.List;

public class CountIslands {
    static boolean[][] visited_arr;
    static int numberOfIslands;
    public static void main(String[] args) {
        List<List<Integer>> matrix = testExample1();

        if(matrix.size() == 0){
//            return 0;
        }
        int columnSize = matrix.size();
        int rowSize = matrix.get(0).size();
        visited_arr = new boolean[columnSize][rowSize];

        count_islands(matrix);
        int a = 5;

//        return numberOfIslands;
    }

    public static int count_islands(List<List<Integer>> matrix) {
        // Write your code here deep search


        for(int columnCount = 0; columnCount < matrix.size(); columnCount++){
            for(int rowCount = 0; rowCount < matrix.get(0).size(); rowCount++){
                if(!visited_arr[columnCount][rowCount] && matrix.get(columnCount).get(rowCount) == 1){
                    numberOfIslands++;
                    helper(matrix, columnCount, rowCount);
                }
            }
        }
        return numberOfIslands;
    }

    public static void helper(List<List<Integer>> matrix, int currCol, int currRow ){
        if(currCol == matrix.size() || currRow == matrix.get(0).size() ||
                currCol < 0 || currRow < 0){
            return;
        }

        if(matrix.get(currCol).get(currRow) == 1 && !visited_arr[currCol][currRow]){
            System.out.println("Col:" + currCol + " Row: " + currCol);
            visited_arr[currCol][currRow] = true;
            helper(matrix, currCol - 1, currRow);
            helper(matrix, currCol + 1, currRow);
            helper(matrix, currCol, currRow + 1);
            helper(matrix, currCol, currRow - 1);
            helper(matrix, currCol - 1, currRow - 1);
            helper(matrix, currCol - 1, currRow + 1);
            helper(matrix, currCol + 1, currRow + 1);
            helper(matrix, currCol + 1, currRow - 1);
        }
    }

    public static List<List<Integer>> testExample1(){
        List<List<Integer>> matrix = new ArrayList<>();

        List<Integer> example = new ArrayList<>();
        example.add(1);
        example.add(1);
        example.add(0);
        example.add(0);
        example.add(0);
        matrix.add(example);

        List<Integer> example2 = new ArrayList<>();
        example2.add(0);
        example2.add(1);
        example2.add(0);
        example2.add(0);
        example2.add(1);
        matrix.add(example2);

        List<Integer> example3 = new ArrayList<>();
        example3.add(1);
        example3.add(0);
        example3.add(0);
        example3.add(1);
        example3.add(1);
        matrix.add(example3);

        List<Integer> example4 = new ArrayList<>();
        example4.add(0);
        example4.add(0);
        example4.add(0);
        example4.add(0);
        example4.add(0);
        matrix.add(example4);

        List<Integer> example5 = new ArrayList<>();
        example5.add(1);
        example5.add(0);
        example5.add(1);
        example5.add(0);
        example5.add(1);
        matrix.add(example5);

        return matrix;
    }
}
