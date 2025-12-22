package sort2;

import java.util.ArrayList;
import java.util.List;

public class lc_1213 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 5, 7, 9};
        int[] arr3 = new int[]{1, 3, 4, 5, 8};

        List<Integer> result = intersection_three_sorted_arr(arr1, arr2, arr3);
        int a = 4;
    }

    public static List<Integer> intersection_three_sorted_arr(int[] arr1, int[] arr2, int[] arr3){
        List<Integer> result = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;
        int ptr3 = 0;

        while(ptr1 < arr1.length && ptr2 < arr2.length && ptr3 < arr3.length) {
            if(arr1[ptr1] == arr2[ptr2]  && arr1[ptr1] == arr3[ptr3]){
                result.add(arr1[ptr1]);
                ptr1++;
                ptr2++;
                ptr3++;
            }else{
                if(arr1[ptr1] < arr2[ptr2] && arr3[ptr3] < arr2[ptr2]){
                    ptr1++;
                    ptr3++;
                }else if(arr2[ptr2] < arr1[ptr1] && arr3[ptr3] < arr1[ptr1]){
                    ptr2++;
                    ptr3++;
                }else if(arr2[ptr2] < arr3[ptr3] && arr1[ptr1] < arr3[ptr3]){
                    ptr1++;
                    ptr2++;
                }else if(arr1[ptr1] < arr2[ptr2] && arr2[ptr2] == arr3[ptr3]){
                    ptr1++;
                }else if(arr2[ptr2] < arr1[ptr1] && arr1[ptr1] == arr3[ptr3]){
                    ptr2++;
                }else if(arr3[ptr3] < arr2[ptr2] && arr2[ptr2] == arr1[ptr1]){
                    ptr3++;
                }
            }
        }
        return result;
    }
}
