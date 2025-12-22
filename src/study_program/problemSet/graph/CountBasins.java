package study_program.problemSet.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountBasins {
    public static void main(String[] args) {
//        {
//            "matrix": [
//            [1, 5, 2],
//            [2, 4, 7],
//            [3, 6, 9]
//            ]
//                    }
//        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 5, 2));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 4, 7));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(3, 6, 9));
//
//        matrix.add(arr1);
//        matrix.add(arr2);
//        matrix.add(arr3);

//        {
//            "matrix": [
//            [0, 2, 1, 3],
//            [2, 1, 0, 4],
//            [3, 3, 3, 3],
//            [5, 5, 2, 1]
//            ]
//        }
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 2, 1, 3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 1, 0, 4));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(3, 3, 3, 3));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(5, 5, 2, 1));

        matrix.add(arr1);
        matrix.add(arr2);
        matrix.add(arr3);
        matrix.add(arr4);

        ArrayList<Integer> result = find_basins(matrix);
        int a = 4;
    }

    static int curr_base_ind;
    static ArrayList<Integer> find_basins(ArrayList<ArrayList<Integer>> matrix) {

        ArrayList<ArrayList<Integer>> basinMatrix = new ArrayList<>();

        for(int i = 0; i < matrix.size(); i++){
            ArrayList<Integer> currLevel = new ArrayList<>();

            for(int j = 0; j < matrix.get(0).size(); j++){
                currLevel.add(-1);
            }
            basinMatrix.add(currLevel);
        }

        curr_base_ind = 1;
        for(int rowInd = 0; rowInd < matrix.size(); rowInd++){
            for(int colInd = 0; colInd < matrix.get(0).size(); colInd++) {
                helper(rowInd, colInd, matrix, basinMatrix, curr_base_ind);
            }
            curr_base_ind++;
        }


        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < curr_base_ind; i++){
            int counter = 0;
            for(int rowInd = 0; rowInd < matrix.size(); rowInd++){
                for(int colInd = 0; colInd < matrix.get(0).size(); colInd++){
                    if(basinMatrix.get(rowInd).get(colInd) == i){
                        counter++;
                    }
                }
            }
            result.add(counter);
        }

        Collections.sort(result);
        return result;
    }

    public static void helper(int rowInd, int colInd, ArrayList<ArrayList<Integer>> matrix,
                              ArrayList<ArrayList<Integer>> basin, int curr_base_ind){
        int rowLength = matrix.size() - 1;
        int colLength = matrix.get(0).size() - 1;

        if(rowInd < 0 || colInd < 0 || rowInd > rowLength || colInd > colLength){
            return;
        }

        if(basin.get(rowInd).get(colInd) != -1)
            return;

        ArrayList<Cell> neighbors = createNeighbors(rowInd, colInd, matrix, basin);

        // find the minimum in neighbors
        int the_min =  matrix.get(rowInd).get(colInd);
        Cell the_min_call = new Cell(rowInd, colInd, the_min, -1);

        for(int i = 0; i < neighbors.size(); i++){
            if(the_min > neighbors.get(i).value){
                the_min_call = neighbors.get(i);
                the_min = neighbors.get(i).value;
            }
        }

        if(the_min_call.basin == -1){
            basin.get(the_min_call.rowInd).set(the_min_call.colInd, curr_base_ind);
            basin.get(rowInd).set(colInd, curr_base_ind);
        }

        helper(rowInd + 1, colInd, matrix, basin, curr_base_ind);
        helper(rowInd, colInd + 1, matrix, basin, curr_base_ind);
        helper(rowInd - 1, colInd, matrix, basin, curr_base_ind);
        helper(rowInd, colInd - 1, matrix, basin, curr_base_ind);
    }

    public static ArrayList<Cell> createNeighbors(int rowInd, int colInd, ArrayList<ArrayList<Integer>> matrix
                            ,ArrayList<ArrayList<Integer>> basin){
        ArrayList<Cell> neighbors = new ArrayList<>();
        int rowLength = matrix.size() - 1;
        int colLength = matrix.get(0).size() - 1;


        if(rowInd - 1 >= 0){
            int value = matrix.get(rowInd - 1).get(colInd);
            int basin_value = basin.get(rowInd - 1).get(colInd);
            Cell cell = new Cell(rowInd - 1, colInd, value, basin_value);
            neighbors.add(cell);
        }

        if(colInd - 1 >= 0){
            int value = matrix.get(rowInd).get(colInd - 1);
            int basin_value = basin.get(rowInd).get(colInd - 1);
            Cell cell = new Cell(rowInd, colInd - 1, value, basin_value);
            neighbors.add(cell);
        }

        if(colInd + 1 <= colLength){
            int value = matrix.get(rowInd).get(colInd + 1);
            int basin_value = basin.get(rowInd).get(colInd + 1);
            Cell cell = new Cell(rowInd, colInd + 1, value, basin_value);
            neighbors.add(cell);
        }

        if(rowInd + 1 <= rowLength){
            int value = matrix.get(rowInd + 1).get(colInd);
            int basin_value = basin.get(rowInd + 1).get(colInd);
            Cell cell = new Cell(rowInd + 1, colInd, value, basin_value);
            neighbors.add(cell);
        }
        return neighbors;
    }

    static class Cell{
        int rowInd;
        int colInd;
        int value;
        int basin;

        public Cell(int rowInd, int colInd, int value, int basin){
            this.rowInd = rowInd;
            this.colInd = colInd;
            this.value = value;
            this.basin = basin;
        }
    }
}
