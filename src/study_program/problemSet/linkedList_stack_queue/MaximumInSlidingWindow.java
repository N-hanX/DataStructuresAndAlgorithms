package study_program.problemSet.linkedList_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumInSlidingWindow {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7));
//        int w = 3;

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(6, 0, -6));
        int w = 1;

        max_in_sliding_window(arr, w);

        int a = 5;
    }

    static ArrayList<Integer> max_in_sliding_window(ArrayList<Integer> arr, Integer w) {
        ArrayList<Max_Info> result_max_info = new ArrayList<>();

        // find the max in list

        Max_Info first_max = find_the_max_in_subarr(arr, 0, 0 + w - 1);
        result_max_info.add(first_max);

        int counter = w;

        while( counter < arr.size()){
            int curr_num = arr.get(counter);

            int the_last_max_ind = result_max_info.get(result_max_info.size() - 1).ind;
            int the_last_max_num = result_max_info.get(result_max_info.size() - 1).num;


            if(the_last_max_ind > counter - w + 1 && curr_num < the_last_max_num){
                result_max_info.add(result_max_info.get(result_max_info.size()- 1));// eger ki en sonda eklenenle ayniysa tekrar ekle
            }else if(the_last_max_ind > the_last_max_num - w + 1 && curr_num > the_last_max_num){
                result_max_info.add(new Max_Info(curr_num, counter));
            }else{
                if(counter - w + 1 >= 0)
                    result_max_info.add(find_the_max_in_subarr(arr, counter - w + 1, counter));
                else
                    result_max_info.add(find_the_max_in_subarr(arr, 0, counter));
            }
            counter++;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < result_max_info.size(); i++){
            result.add(result_max_info.get(i).num);
        }

        return result;
    }

    static Max_Info find_the_max_in_subarr(ArrayList<Integer> arr, int startInd, int endInd){

        if(arr.isEmpty())
            return null;

        int counter = startInd;
        int max_num = arr.get(counter);
        int max_ind = counter;

        while(counter <= endInd){
            if (max_num < arr.get(counter)) {
                max_num = arr.get(counter);
                max_ind = counter;
            }
            counter++;
        }

        return new Max_Info(max_num, max_ind);
    }

    static class Max_Info{
        int num;
        int ind;

        public Max_Info(int num, int ind){
            this.num = num;
            this.ind = ind;
        }
    }
}
