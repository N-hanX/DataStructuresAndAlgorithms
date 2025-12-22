package study_lc;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    static Set<Integer> calculatedResult = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(isHappy(23));
        int a = 5;
    }
    public static boolean isHappy(int n) {
        // end condition is one digit number
        int prevTemp = n;

        if(n==13){
            return true;
        }
        do{
            // calculate the total digit
            int remainingTotal = 0;
            calculatedResult.add(n);
            int temp = n;
            prevTemp = n;

            while(temp / 10 > 0){
                remainingTotal += Math.pow(temp%10,2);
                temp = temp/10;
                // System.out.println("temp: " + temp);
                // System.out.println("remainintotal: " + remainingTotal);
            }
            // System.out.println("tempson: " + temp);
            remainingTotal += Math.pow(temp, 2);
            // System.out.println("remainintotalson: " + remainingTotal);
            n = remainingTotal;
            if(n == 1){ // happy number cond
                return true;
            }
        }while(!calculatedResult.contains(n));
        return false;
    }
}
