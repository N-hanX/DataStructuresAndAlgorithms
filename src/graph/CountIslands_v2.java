package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CountIslands_v2 {
    public static void main(String[] args) {
        ArrayList<Integer> matrix1 = new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0));
        ArrayList<Integer> matrix2 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1));
        ArrayList<Integer> matrix3 = new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1));
        ArrayList<Integer> matrix4 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        ArrayList<Integer> matrix5 = new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(matrix1);
        result.add(matrix2);
        result.add(matrix3);
        result.add(matrix4);
        result.add(matrix5);

        Integer numOfIslands = count_islands(result);

        int a = 5;
    }

    static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) {
        Integer numOfIslands = 0;
        int yColumnSize = matrix.get(0).size();
        int xColumnSize = matrix.size();

        for(int i = 0; i < yColumnSize; i++){
            for(int j = 0; j < xColumnSize; j++){
                if((matrix.get(j)).get(i) == 2 || (matrix.get(j)).get(i) == 3)
                    continue;

                if((matrix.get(j)).get(i) == 1) {
                    numOfIslands++;
                    traverse_island(matrix, j, i);
                    continue;
                }

                if((matrix.get(j)).get(i) == 0) {
                    (matrix.get(j)).set(i, 2);
                }
            }
        }
        return numOfIslands;
    }

    static void traverse_island(ArrayList<ArrayList<Integer>> matrix, int x, int y){
        int yColumnSize = matrix.get(0).size();
        int xColumnSize = matrix.size();

        if(x < xColumnSize && y < yColumnSize && x >= 0 && y >= 0) {
        }else{
            return;
        }
        if((matrix.get(x)).get(y) == 2 || (matrix.get(x)).get(y) == 3)
            return;

        if((matrix.get(x)).get(y) == 1){
            (matrix.get(x)).set(y, 3);
        }
        if((matrix.get(x)).get(y) == 0){
            (matrix.get(x)).set(y, 2);
            return;
        }

        traverse_island(matrix, x - 1, y);
        traverse_island(matrix, x, y - 1);
        traverse_island(matrix, x + 1, y);
        traverse_island(matrix, x, y + 1);
        traverse_island(matrix, x - 1, y - 1);
        traverse_island(matrix, x + 1, y + 1);
        traverse_island(matrix, x + 1, y - 1);
        traverse_island(matrix, x - 1, y + 1);

    }
}
