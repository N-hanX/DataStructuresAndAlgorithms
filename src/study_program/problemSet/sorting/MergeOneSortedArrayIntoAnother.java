package study_program.problemSet.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOneSortedArrayIntoAnother {
    public static void main(String[] args) {
//        "first": [1, 3, 5],
//        "second": [2, 4, 6, 0, 0, 0]

//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 3, 5));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 4, 6, 0, 0, 0));

//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 0));

//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 0));

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(11, 14, 24, 34, 44, 45, 45, 47, 61, 64, 72, 82, 103,
                104, 122, 122, 131, 138, 145, 148, 150, 151, 185, 198));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(6, 9, 17, 19, 28, 33, 35, 36, 64, 76, 87, 89, 107,
                110, 112, 121, 129, 132, 139, 146, 151, 152, 154, 175, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));


        merge_one_into_another(arr1, arr2);

    }


    static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
        if(first.isEmpty()){
            return null;
        }
        int numOfArrLen = first.size();
        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 < numOfArrLen && ptr2 < second.size()){
            if(first.get(ptr1) <= second.get(ptr2)){
                second.add(ptr2, first.get(ptr1));

                if(second.get(second.size() - 1) == 0){
                    second.remove(second.size() - 1);
                }
                ptr1++;
            }else{
                ptr2++;
            }
        }

        int theLastEmptyIndex = second.size() - 1;
        int theLastIndexOfFirstArr = first.size() - 1;

        while(ptr1 <= theLastIndexOfFirstArr && second.get(theLastEmptyIndex) == 0 ){
            second.set(theLastEmptyIndex, first.get(theLastIndexOfFirstArr));
            theLastEmptyIndex--;
            theLastIndexOfFirstArr--;
        }

        return second;
    }

}
