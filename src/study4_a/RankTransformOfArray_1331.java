package study4_a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfArray_1331 {
    static void main() {
        // TEST1
//        int[] arr = new int[]{40,10,20,30};
//        int[] result = arrayRankTransform(arr);

        // TEST2
        int[] arr2 = new int[]{40,10,10,20,30};
        int[] result2 = arrayRankTransform(arr2);


        int a =4;
    }
    public static int[] arrayRankTransform(int[] arr) {
        int[] arr2 = new int[arr.length];
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2);

        Map<Integer, Integer> sortingMap = new HashMap<>();

        int counter = 1;
        for(int i = 0; i < arr2.length; i++){
            if(!sortingMap.containsKey(arr2[i])){
                sortingMap.put(arr2[i], counter);
                counter++;
            }
        }

        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = sortingMap.get(arr[i]);
        }

        return result;
    }
}
