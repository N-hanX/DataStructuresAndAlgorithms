package study_program.problemSet.dynamics;

import java.util.ArrayList;
import java.util.Arrays;

public class Robbery {
    public static void main(String[] args) {
//        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(6, 1, 2, 7));

        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(8, 9, 9, 10, 5, 7, 3, 9, 2, 5));

        Integer result = maximum_stolen_value(values);

        int a = 5;
    }

    static Integer maximum_stolen_value(ArrayList<Integer> values) {
        if(values.isEmpty())
            return null;

        if(values.size() == 1)
            return values.get(0);

        int[] total_stolen_values = new int[values.size()];

        int curr_house = 0;
        total_stolen_values[0] = values.get(0);

        while(curr_house < values.size()){
            if(curr_house >= 2)
                total_stolen_values[curr_house] = Math.max(total_stolen_values[curr_house - 2] + values.get(curr_house),
                                        total_stolen_values[curr_house - 1]);
            else if(curr_house == 1){
                total_stolen_values[curr_house] = Math.max(values.get(curr_house),
                        total_stolen_values[curr_house - 1]);
            }
            curr_house++;
        }

        return total_stolen_values[total_stolen_values.length - 1];
    }
}
