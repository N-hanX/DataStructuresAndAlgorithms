package study_program.problemSet.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        ArrayList<Character> colors = new ArrayList<>(Arrays.asList('G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'));

        dutch_flag_sort(colors);

        int a;
    }


    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {

        int red_ptr = 0;
        int blue_ptr = balls.size() - 1;

        int counter = 0;

        while(counter <= blue_ptr){
            char curr_char = balls.get(counter);

            if(curr_char == 'R'){
                char the_char_in_red_part = balls.get(red_ptr);
                balls.set(red_ptr, curr_char);
                red_ptr++;

                balls.set(counter, the_char_in_red_part);
                counter++;
            }else if(curr_char == 'B'){
                char the_char_in_blue_part = balls.get(blue_ptr);
                balls.set(blue_ptr, curr_char);
                blue_ptr--;

                balls.set(counter, the_char_in_blue_part);
            }else{
                counter++;
            }
        }

        return balls;
    }

}
