package sorting.homework;

public class MergeSortedArray1 {
    public static void main(String[] args) {
        int[] arr1= {1,2,3,0,0,0};
        int arr1_size = 3;

        int[] arr2= {2,5,6};

        mergeSortedArray(arr1,arr2, arr1_size);

    }


    public static int[] mergeSortedArray(int[] arr1, int[] arr2, int arr1_size){
        int pointer1 = 0;
        int pointer2 = 0;
        int[] result = new int[arr2.length + arr1_size];
        int currResultInd = 0;

        while(pointer2 < arr2.length && pointer1 < arr1_size ){
            if( arr1[pointer1] < arr2[pointer2]){
                result[currResultInd] = arr1[pointer1];
                pointer1++;
                currResultInd++;
            }else if(arr2[pointer2] < arr1[pointer1]){
                result[currResultInd] = arr2[pointer2];
                pointer2++;
                currResultInd++;
            }else if(arr1[pointer1] == arr2[pointer2]){
                result[currResultInd] = arr1[pointer1];
                currResultInd++;

                result[currResultInd] = arr2[pointer2];
                currResultInd++;

                pointer1++;
                pointer2++;

            }
        }

        while(pointer1 < arr1_size){
            result[currResultInd] = arr1[pointer1];
            currResultInd++;
            pointer1++;
        }

        while(pointer2 < arr2.length){
            result[currResultInd] = arr2[pointer2];
            currResultInd++;
            pointer2++;
        }

        return result;
    }
}
