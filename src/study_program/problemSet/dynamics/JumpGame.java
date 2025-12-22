package study_program.problemSet.dynamics;

import java.util.ArrayList;
import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
//        ArrayList<Integer> maximum_jump_lengths = new ArrayList<>(Arrays.asList(2, 3, 1, 0, 4, 7));
        ArrayList<Integer> maximum_jump_lengths = new ArrayList<>(Arrays.asList(3, 1, 1, 0, 2, 4));

        Boolean result = can_reach_last_house(maximum_jump_lengths);

        int a;
    }


    static Boolean can_reach_last_house(ArrayList<Integer> maximum_jump_lengths) {
        boolean[] destination_possibility = new boolean[maximum_jump_lengths.size()];

        int the_length_of_last_house = maximum_jump_lengths.size() - 1;

        destination_possibility[the_length_of_last_house] = true;

        for(int i = the_length_of_last_house - 1; i >= 0; i--){
            int max_jump = maximum_jump_lengths.get(i);

            int count = 1;
            int curr_location = i;

            while(destination_possibility[i] == true && count <= max_jump && (curr_location - count) >= 0){
                destination_possibility[curr_location - count] = true;
                count++;
            }
        }

        return destination_possibility[destination_possibility.length - 1];
    }




}
