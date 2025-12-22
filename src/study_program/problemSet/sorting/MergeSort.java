package study_program.problemSet.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));

        ArrayList<Integer> sorted_arr = merge_sort(arr);

        int a = 5;
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        return merge_helper(arr, 0, arr.size() - 1);
    }

    static ArrayList<Integer> merge_helper(ArrayList<Integer> arr, int startInd, int endInd){
        if(startInd < 0 || startInd >= arr.size() || endInd < 0 || endInd >= arr.size()){
            return null;
        }

        if(startInd == endInd){
            return new ArrayList<>(Arrays.asList(arr.get(startInd)));
        }

        int midInd = startInd + (endInd - startInd) / 2;

        ArrayList<Integer> list1 = merge_helper(arr, startInd, midInd);
        ArrayList<Integer> list2 = merge_helper(arr, midInd + 1, endInd);

        return merge_lists(list1, list2);

    }

    static ArrayList<Integer> merge_lists(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int ptr1 = 0;
        int ptr2 = 0;

        ArrayList<Integer> sorted_list = new ArrayList<>();

        // 3, 4, 7  =  1,4,7,


        // 1, 5, 8 = 3,5,8,


        while(ptr1 < list1.size() && ptr2 < list2.size()){
            if(list1.get(ptr1) < list2.get(ptr2)){
                sorted_list.add(list1.get(ptr1));
                ptr1++;
            }else if(list1.get(ptr1) >= list2.get(ptr2)){
                sorted_list.add(list2.get(ptr2));
                ptr2++;
            }
        }

        while(ptr1 < list1.size()){
            sorted_list.add(list1.get(ptr1));
            ptr1++;
        }

        while(ptr2 < list2.size()){
            sorted_list.add(list2.get(ptr2));
            ptr2++;
        }

        return sorted_list;
    }
}
