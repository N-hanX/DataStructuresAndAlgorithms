package sorting.homework;

public class MergeSortedArray2 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int arr1_size = 3;

        int[] arr2 = {2, 5, 6};

        mergeSortedArray2(arr1, arr2, arr1_size);
    }
    public static int[] mergeSortedArray2(int[] arr1, int[] arr2, int arr1_size){
        int currentEndInd = arr1_size - 1;
        int pointer1 = 0;
        int pointer2 = 0;

        while(pointer1 < currentEndInd && pointer2 < arr2.length){
            if(arr1[pointer1] < arr2[pointer2]){
                pointer1++;
            }else if (arr2[pointer2] < arr1[pointer1] || arr1[pointer1] == arr2[pointer2]){
                // swipe other elements to the right in arr1
                int temp_pointer1 = currentEndInd + 1;
                while(temp_pointer1 > pointer1){
                    arr1[temp_pointer1] = arr1[temp_pointer1 - 1];
                    temp_pointer1--;
                }
                arr1[pointer1 + 1] = arr2[pointer2];
                pointer1++;
                pointer2++;
                currentEndInd++;
            }
        }

        while(pointer2 < arr2.length){
            arr1[pointer1 + 1] = arr2[pointer2];
            pointer1++;
            pointer2++;
        }

        return arr1;
    }

}
