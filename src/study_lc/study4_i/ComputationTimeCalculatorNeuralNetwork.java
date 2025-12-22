package study_lc.study4_i;

import java.util.*;

public class ComputationTimeCalculatorNeuralNetwork {
    public static void main(String[] args) {
//        List<Integer> netTimes = new ArrayList<>(Arrays.asList(2, 4, 8, 16));
//        List<Integer> netTimes = new ArrayList<>(Arrays.asList(1, 5, 7));
//        List<Integer> netTimes = new ArrayList<>(Arrays.asList(24, 46, 48, 17, 34, 102));

        List<Integer> netTimes = new ArrayList<>(Arrays.asList(16, 24, 46, 92, 144, 2, 48, 17, 34, 102));

        int result = computationTime(netTimes);

        int a = 4;

    }

    public static int computationTime(List<Integer> netTimes){
        Collections.sort(netTimes);
        Collections.reverse(netTimes);
        List<Integer> origList =  netTimes;

        int total_change = 0;
        int index = 0;

        while(index < netTimes.size()){
            int curr_max_val = netTimes.get(index);

            if(curr_max_val % 2 == 1){
                index++;
                continue;
            }else{
                // insert the Value
                // calculate the number of curr_max_val
                total_change++;

                int count_the_same_max = 1;

                while( count_the_same_max + index < netTimes.size()
                        && netTimes.get(count_the_same_max + index) == curr_max_val){
                    count_the_same_max++;
                }

                int new_curr_val = curr_max_val / 2;
                int temp_index = index;
                while(temp_index < netTimes.size() && netTimes.get(temp_index) > new_curr_val){
                    temp_index++;
                }

                int counter = 0;

                while(counter < count_the_same_max){

                    netTimes.add(temp_index + counter, new_curr_val);


                    counter++;
                }

                counter = 0;

                while(counter < count_the_same_max){
                    netTimes.remove(index);
                    counter++;
                }
            }
        }

        return total_change;
    }

}
