package study_program.lectureNotes.linkedLists.Insertion_Deletion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        boolean result = isHappyNumber(19);
        int a = 5;
    }

    public static boolean isHappyNumber(int number){
        Set<Integer> calculatedTotals = new HashSet<>();
        Integer curr_total = sumOfSquareEachDigit(number);

        while(!calculatedTotals.contains(curr_total)){
            calculatedTotals.add(curr_total);

            curr_total = sumOfSquareEachDigit(curr_total);


            if(curr_total == 1)
                return true;
        }

        return false;
    }

    public static Integer sumOfSquareEachDigit(int number){
        ArrayList<Integer> digitList = findEachDigit(number);

        Integer total = 0;

        for(int i = 0; i < digitList.size(); i++){
            total += digitList.get(i) * digitList.get(i);
        }
        return total;
    }

    public static ArrayList<Integer> findEachDigit(int number){
        ArrayList<Integer> digitList = new ArrayList<>();

        int remained = number % 10;


        while((number / 10) > 0){
            remained = number % 10;
            number = number / 10;
            digitList.add(remained);
        }

        if(number != 0){
            digitList.add(number);
        }
        return digitList;
    }
}
