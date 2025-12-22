package study_program.problemSet.adhoc;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_2D_Array_Search {
    public static void main(String[] args) {
//        {
//            "numbers": [
//[1, 2, 3, 12],
//[4, 5, 6, 45],
//[7, 8, 9, 78]
//],
//            "queries": [6, 7, 23]
//        }

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 12));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 5, 6, 45));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(7, 8, 9, 78));
        ArrayList<ArrayList<Integer>> number = new ArrayList<>();

        number.add(arr1);
        number.add(arr2);
        number.add(arr3);

        ArrayList<Integer> queries = new ArrayList<>(Arrays.asList(6, 7, 23));


//        {
//            "numbers": [
//[-88, -87, -30],
//[-61, -22, 18],
//[-22, 65, 65],
//[-10, 113, 198]
//],
//            "queries": [-6, -10, 6, 37]
//        }

//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-88, -87, -30));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(-61, -22, 18));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(-22, 65, 65));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(-10, 113, 198));
//        ArrayList<ArrayList<Integer>> number = new ArrayList<>();
//
//        number.add(arr1);
//        number.add(arr2);
//        number.add(arr3);
//        number.add(arr4);
//
//        ArrayList<Integer> queries = new ArrayList<>(Arrays.asList(-6, -10, 6, 37));

        ArrayList<Boolean> result = search(number, queries);
        int a = 5;
    }


    static ArrayList<Boolean> search(ArrayList<ArrayList<Integer>> numbers, ArrayList<Integer> queries) {
        ArrayList<Boolean> queryResult = new ArrayList<>();
        queryResult.ensureCapacity(queries.size());

        for(int i = 0; i < queries.size(); i++){

            // find the Row
            int curr_rowInd = 0;

            while(curr_rowInd < numbers.size() &&
                    queries.get(i) > numbers.get(curr_rowInd).get(numbers.get(0).size() - 1) ){
                curr_rowInd++;
            }

            if(curr_rowInd < numbers.size() && queries.get(i) < numbers.get(curr_rowInd).get(0)){
                queryResult.add(false);
            }else{
                queryResult.add(binarySearchByRow(numbers, curr_rowInd, queries.get(i), 0,
                        numbers.get(0).size() - 1));
            }
        }

        return queryResult;
    }

    static Boolean binarySearchByRow(ArrayList<ArrayList<Integer>> numbers, int currRowInd,
                                     int currNumber, int startColInd, int endColInd){

        System.out.println("start Col: " + startColInd + " end col ind: " + endColInd + " row ind: " + currRowInd);

        if(startColInd < 0 || endColInd < 0 || currRowInd < 0 || startColInd >= numbers.get(0).size()
                || endColInd >= numbers.get(0).size() || currRowInd >= numbers.size()){
            return false;
        }

        if(startColInd > endColInd){
            return false;
        }

        int middleColInd = (endColInd - startColInd) / 2  + startColInd;

        int current_reference_number = numbers.get(currRowInd).get(middleColInd);

        if(current_reference_number == currNumber){
            return true;
        }

        if(middleColInd == startColInd && middleColInd == endColInd){
            // diger row da olma ihtimalini kontrol edelim
            if(currRowInd + 1 < numbers.size()){
                int next_Row_start_val = numbers.get(currRowInd + 1).get(0);
                int next_Row_end_val = numbers.get(currRowInd + 1).get(numbers.get(0).size() - 1);

                if(next_Row_start_val > currNumber){
                    return false;
                }
                if(next_Row_end_val < currNumber){
                    return false;
                }
            }else{
                return false;
        }

            return binarySearchByRow(numbers, currRowInd + 1, currNumber, 0, startColInd) ||
                    binarySearchByRow(numbers, currRowInd + 1, currNumber, startColInd, endColInd);
        }

        if( current_reference_number > currNumber){
            return binarySearchByRow(numbers, currRowInd, currNumber, startColInd, middleColInd - 1);
        }else{
            return binarySearchByRow(numbers, currRowInd, currNumber, middleColInd + 1, endColInd);
        }
    }
}
