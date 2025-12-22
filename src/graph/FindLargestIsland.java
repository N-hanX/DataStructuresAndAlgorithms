package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FindLargestIsland {
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

        Integer largestIsland = max_island_size(result);
        int a = 6;
    }

    static int count = 0;
    static int max = 0;
    static Integer max_island_size(ArrayList<ArrayList<Integer>> grid) {
        int xDimensionSize = grid.size(); // vertical
        int yDimensionSize = grid.get(0).size(); // horizontal

        for(int i = 0; i < xDimensionSize; i++){
            for(int j = 0; j < yDimensionSize; j++){
                count = 0;
                int currCellVal = grid.get(i).get(j);
                if(currCellVal == 0){
                    grid.get(i).set(j, 2);
                    continue;
                }
                if(currCellVal == 2 || currCellVal == 3){
                    continue;
                }
                if(currCellVal == 1){
                    calculateIslandSize(grid, i,j);
                }
                if(max < count){
                    max = count;
                }
            }
        }


        return max;
    }

    static void calculateIslandSize(ArrayList<ArrayList<Integer>> grid, int x, int y) {
        int xDimensionSize = grid.size(); // vertical
        int yDimensionSize = grid.get(0).size(); // horizontal

        if(x < xDimensionSize && x >= 0 && y >= 0 && y < yDimensionSize){

        }else{
            return;
        }

        int currCellVal = grid.get(x).get(y);

        if(currCellVal == 2 || currCellVal == 3){
            return;
        }

        if(currCellVal == 1){
            count++;
            grid.get(x).set(y, 3);
        }

        if(currCellVal == 0){
            grid.get(x).set(y, 2);
            return;
        }

        calculateIslandSize(grid, x + 1 ,y);
        calculateIslandSize(grid, x ,y + 1);
        calculateIslandSize(grid, x - 1, y);
        calculateIslandSize(grid, x, y - 1);
    }
}
