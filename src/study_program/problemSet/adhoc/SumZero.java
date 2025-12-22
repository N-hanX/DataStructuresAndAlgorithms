package study_program.problemSet.adhoc;

import java.util.ArrayList;
import java.util.Arrays;

public class SumZero {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 1, 2, -3, 7, -4));

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 0, 5, -9));



        ArrayList<Integer> result = sum_zero(arr);
        int a = 5;
    }

    static ArrayList<Integer> sum_zero(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        search_sum_zero(arr, 0, arr.size(), null, result);

        if(result.isEmpty())
            result.add(-1);

        return result;
    }

    static void search_sum_zero(ArrayList<Integer> arr, int start_ind, int end_ind, Integer currTotal,
                                ArrayList<Integer> result){

        for(int curr_start_ind = start_ind; curr_start_ind < end_ind; curr_start_ind++){
            int curr_end_ind = curr_start_ind;
            long total = 0;

            while(curr_end_ind < arr.size()){

                total += (long)arr.get(curr_end_ind);

//                System.out.println(total);
                if(total > Integer.MAX_VALUE && total < Integer.MIN_VALUE){
                    System.out.println("totalover");
                    break;
                }


                if(total == 0L){
                    result.add(curr_start_ind);
                    result.add(curr_end_ind);
                    return;
                }
                curr_end_ind++;
            }
        }
    }
}
