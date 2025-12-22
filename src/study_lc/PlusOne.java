package study_lc;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {9,9,9,9};

        int one_more = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            if(i == arr.length - 1 && arr[i] != 9){
                arr[i] = arr[i] + 1;
                one_more = 0;
            }
            else if(i == arr.length - 1 && arr[i] == 9){
                arr[i] = 0;
                one_more = 1;
            }
            else if(one_more == 1 && arr[i] != 9){
                arr[i] = arr[i] + 1;
                one_more = 0;
            }
            else if(one_more == 1 && arr[i] == 9){
                arr[i] = 0;
                one_more = 1;
            }
        }

        int[] new_arr = new int[arr.length + 1];
        if(one_more == 1 && arr[0] == 0){
            for(int i = 0; i < arr.length; i++){
                if(i == 0){
                    new_arr[0] = 1;
                }
                else{
                    new_arr[i] = arr[i - 1];
                }
            }
        }


        int[] temp = new_arr;
    }
}
