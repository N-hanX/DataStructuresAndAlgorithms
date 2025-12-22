package sorting.problemSet;

import java.util.ArrayList;
import java.util.Arrays;

public class OnlineMedian {
    public static void main(String[] args) {
        ArrayList<Integer> stream = new ArrayList<>(Arrays.asList(3, 4, 6, 22, 8, 3));
        ArrayList<Integer> result = online_median(stream);
        int a = 5;
    }


    static ArrayList<Integer> online_median(ArrayList<Integer> stream) {
        ArrayList<Integer> result_num_list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < stream.size(); i++){
            insertion(result_num_list, stream.get(i), 0, result_num_list.size());

            int result_size = result_num_list.size();
            if(result_size % 2 == 1){
                int middle_ind = result_size / 2;
                int median = result_num_list.get(middle_ind);
                System.out.println(median);
                result.add(median);
            }else{
                int middle_ind = result_size / 2;
                int median = (result_num_list.get(middle_ind) + result_num_list.get(middle_ind - 1))/2;
                System.out.println(median);
                result.add(median);
            }
        }
        return result;
    }

    public static void insertion(ArrayList<Integer> list, int num, int left, int right){
        if(  list.size() == 0){
            list.add(0, num);
            return;
        }
        if(right == -1){
            list.add(0,num);
            return;
        }
        if(left == list.size()){
            list.add(num);
            return;
        }

        int middle_ind = left + (right - left) / 2;
        System.out.println("left" + left);
        System.out.println("right" + right);
        System.out.println("middle" + middle_ind);

        if(left >= right){
            if(list.get(left) < num){
                list.add(left + 1, num);
                return;
            }else{
                list.add(left, num);
                return;
            }
        }

        if(list.get(middle_ind) >= num){
            insertion(list, num, left, middle_ind - 1);
        }else if(list.get(middle_ind) < num){
            insertion(list, num, middle_ind + 1, right);
        }
        return;
    }
}
