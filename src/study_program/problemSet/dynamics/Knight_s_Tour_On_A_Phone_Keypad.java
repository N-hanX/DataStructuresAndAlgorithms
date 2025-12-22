package study_program.problemSet.dynamics;

import java.util.*;

public class Knight_s_Tour_On_A_Phone_Keypad {
    public static void main(String[] args) {
        int start_digit = 2;
        int phone_number_length = 4;

        Long result = count_phone_numbers_of_given_length(start_digit, phone_number_length);
        int a = 5;
    }



    static Long count_phone_numbers_of_given_length(Integer start_digit, Integer phone_number_length) {
        if(phone_number_length == 0){
            return 0L;
        }

        if(start_digit == 5 && phone_number_length == 1){
            return 1L;
        }

        if(start_digit == 5){
            return 0L;
        }

        Map<Integer, ArrayList<Integer>> digit_movements = new HashMap<>();

        int digit_counter = 0;

        ArrayList<Integer> list;
        while(digit_counter <= 9){
            switch (digit_counter){
                case(0):
                    list = new ArrayList<>(Arrays.asList(4, 6));
                    break;
                case(1):
                    list = new ArrayList<>(Arrays.asList(6, 8));
                    break;
                case(2):
                    list = new ArrayList<>(Arrays.asList(7, 9));
                    break;
                case(3):
                    list = new ArrayList<>(Arrays.asList(4, 8));
                    break;
                case(4):
                    list = new ArrayList<>(Arrays.asList(3, 9, 0));
                    break;
                case(5):
                    list = null;
                    break;
                case(6):
                    list = new ArrayList<>(Arrays.asList(1, 7, 0));
                    break;
                case(7):
                    list = new ArrayList<>(Arrays.asList(2, 6));
                    break;
                case(8):
                    list = new ArrayList<>(Arrays.asList(3, 1));
                    break;
                case(9):
                    list = new ArrayList<>(Arrays.asList(4, 2));
                    break;
                default:
                    list = null;
                    break;
            }
            digit_movements.put(digit_counter, list);
            digit_counter++;
        }

        int count_line = 1;
        Map<Integer, Long> prevLastDigits = new HashMap<>();
        prevLastDigits.put(start_digit, 1L);


        while(count_line < phone_number_length){
            Map<Integer, Long> currLastDigits = new HashMap<>();

            for (int curr_digit : prevLastDigits.keySet()) {
                Long total_num_of_curr_digit = prevLastDigits.get(curr_digit);

                ArrayList<Integer> curr_digit_movements = digit_movements.get(curr_digit);

                for(int i = 0; i < curr_digit_movements.size(); i++){
                    int new_digit = curr_digit_movements.get(i);
                    if (currLastDigits.containsKey(new_digit)) {
                        Long totalNumber = currLastDigits.get(new_digit);
                        currLastDigits.put(new_digit, totalNumber + total_num_of_curr_digit);
                    } else {
                        currLastDigits.put(new_digit, total_num_of_curr_digit);
                    }
                }
            }
            prevLastDigits = currLastDigits;
            count_line++;
        }

        Long total_num_of_phone = 0L;

        Iterator<Integer> map_iterator = prevLastDigits.keySet().iterator();

        while(map_iterator.hasNext()){
            int curr_digit = map_iterator.next();
            total_num_of_phone += prevLastDigits.get(curr_digit);
        }

        return total_num_of_phone;
    }


}
