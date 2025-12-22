package sort2;

import java.util.Arrays;

public class three_sum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 17, 19, 10, 50};
        int sum = 71;
        int[] result = three_sum(arr, sum);
        int a = 5;
    }

    public static int[] three_sum(int[] arr, int sum){
        int[] copy = arr.clone();

        Arrays.sort(arr);
        boolean found = false;

        int[] result = new int[3];
        for(int i = 0; i < arr.length; i++){
            int leftPtr = i + 1;
            int rightPtr = arr.length - 1;
            int curr_sum = sum - arr[i];

            while(leftPtr < rightPtr){
                if(arr[leftPtr] + arr[rightPtr] > curr_sum){
                    rightPtr--;
                }else if(arr[leftPtr] + arr[rightPtr] < curr_sum){
                    leftPtr++;
                }else{
                    result[0] = i;
                    result[1] = leftPtr;
                    result[2] = rightPtr;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        int count = 0;
        for(int i = 0; i < copy.length; i++){
            if(copy[i] == arr[result[0]] || copy[i] == arr[result[1]] || copy[i] == arr[result[2]]){
                result[count] = i;
                count++;
                if(count == 3){
                    break;
                }
            }
        }

        return result;
    }
}
