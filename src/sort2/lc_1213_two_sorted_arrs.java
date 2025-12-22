package sort2;

import java.util.ArrayList;
import java.util.List;

public class lc_1213_two_sorted_arrs {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 3, 5, 5, 6, 7, 7, 8, 12};
        int[] arr2 = new int[]{5, 5, 6, 8, 8, 9, 10, 10};

        List<Integer> result = two_sorted_arrs(arr1, arr2);
        int a = 5;
    }

    public static List<Integer> two_sorted_arrs(int[] arr1, int[] arr2){
        int ptr1 = 0;
        int ptr2 = 0;
        List<Integer> result = new ArrayList<>();
        int prev = Integer.MIN_VALUE;

        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] == arr2[ptr2] && arr1[ptr1] != prev){
                prev = arr1[ptr1];
                result.add(arr1[ptr1]);
                ptr1++;
                ptr2++;
            }else{
                if(arr1[ptr1] < arr2[ptr2]){
                    ptr1++;
                }else if(arr2[ptr2] < arr1[ptr1]){
                    ptr2++;
                }else{
                    ptr1++;
                    ptr2++;
                }
            }
        }
        return result;
    }
}
