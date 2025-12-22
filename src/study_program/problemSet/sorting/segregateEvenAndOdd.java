package study_program.problemSet.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class segregateEvenAndOdd {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2,10,1,5,8,4));

        segregate_evens_and_odds(nums);

        int a;

    }

    static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {

        int oddNumberIndex = 0;
        int indexCounter = 0;

        while(indexCounter < numbers.size()){
            int currNum = numbers.get(indexCounter);

            if(currNum % 2 == 0){
                int theStartOfOddNum = numbers.get(oddNumberIndex);
                numbers.set(oddNumberIndex, currNum);
                numbers.set(indexCounter, theStartOfOddNum);
                indexCounter++;
                oddNumberIndex++;
            }else{
                indexCounter++;
            }

        }

        return numbers;
    }


}
