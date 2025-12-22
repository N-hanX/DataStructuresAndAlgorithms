package recursion.homework;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PermuteArray {

    public static void main(String[] args) {
        List<Integer> actualList = new ArrayList<Integer>();

        actualList.add(1);
        actualList.add(2);
        actualList.add(3);

        // mask The array
        boolean[] mask = maskTheArr(actualList);

        ArrayList<ArrayList<Integer>> allResults = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        permuteHelper(mask, actualList, allResults, currentList);
    }

    public static void permuteHelper (boolean[] mask,
                                      List<Integer> actualList, ArrayList<ArrayList<Integer>> allResults,
                                      ArrayList<Integer> currentList ){
        boolean allElementsUsed = false;


        //check mask array
        for(int i = 0; i < mask.length; i++ ){
            if(mask[i] == false) {
                allElementsUsed = true;
                currentList.add(actualList.get(i));
                mask[i] = true;
                permuteHelper(mask, actualList, allResults, currentList);
                mask[i] = false;
                currentList.remove(currentList.size() - 1);
            }
        }

        if(allElementsUsed == false){
            ArrayList<Integer> newList = new ArrayList<>(currentList);
            allResults.add(newList);
            return;
        }
    }



    public static boolean[]  maskTheArr(List<Integer> list){
        boolean[] mask = new boolean[list.size()];

        for(int i = 0; i < list.size(); i++){
            mask[i] = false;
        }
        return mask;
    }
}

