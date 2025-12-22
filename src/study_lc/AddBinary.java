package study_lc;

import java.util.ArrayList;

public class AddBinary {
    static ArrayList<Integer> arrList = new ArrayList<>();

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";

        int int_a = a.length() - 1;
        int int_b = b.length() - 1;

        int one_more = 0;

        while(int_a >= 0 && int_b >= 0) {
            int curr_result = Character.getNumericValue(a.charAt(int_a)) + Character.getNumericValue(b.charAt(int_b)) + one_more;
            one_more = adding(curr_result);
            int_a--;
            int_b--;
        }

        while(int_a >= 0){
            int curr_result = Character.getNumericValue(a.charAt(int_a)) + one_more;
            one_more = adding(curr_result);
            int_a--;
        }

        while(int_b >= 0){
            int curr_result = Character.getNumericValue(b.charAt(int_b)) + one_more;
            one_more = adding(curr_result);
            int_b--;
        }
        if(one_more == 1){
            arrList.add(1);
        }

        String result = "";
        for(int i = arrList.size() - 1; i >= 0; i--){
            result = result + arrList.get(i).toString();
        }
        int bb = 5;
    }

    public static int adding( int curr_result){
        int one_more = 0;

        if (curr_result == 2 && one_more == 0) {
            arrList.add(0);
            one_more = 1;
        }else if (curr_result == 2 && one_more == 1) {
            arrList.add(1);
            one_more = 0;
        } else if (curr_result == 1 && one_more == 1) {
            arrList.add(0);
            one_more = 1;
        } else if (curr_result == 1 && one_more == 0) {
            arrList.add(1);
            one_more = 0;
        }else if (curr_result == 0 && one_more == 1) {
            arrList.add(1);
            one_more = 0;
        }else if (curr_result == 0 && one_more == 0) {
            arrList.add(0);
            one_more = 0;
        }
        return one_more;
    }
}
