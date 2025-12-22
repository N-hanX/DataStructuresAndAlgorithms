package study_lc.study4_c;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfKMirrorNumbers_2081 {
    public static void main(String[] args) {

    }
    public long kMirror(int k, int n) {
        long result = 0L;
        int counter = 0;
        Queue<String> possibleBaseNums = new LinkedList<>();

        for(int i = 1; i < k; i++){
            possibleBaseNums.add(String.valueOf(i));
            counter++;
            result += i;
        }

        while(counter < n){
            int curr_size = possibleBaseNums.size();
            int currNumLenCounter = 0;

            while(currNumLenCounter < curr_size){
                String curr_base = possibleBaseNums.poll();
                for(int i = 0; i < k; i++){
                    String next_int = curr_base + String.valueOf(i);
                    // System.out.println("next_int: " + next_int);
                    // if has mirror
                    possibleBaseNums.add(next_int);
                    if(hasMirror(next_int)){
                        int decimal_int = convertDecimal(next_int, k);
                        // System.out.println("decimal_int : " + decimal_int);
                        if(hasMirror(String.valueOf(decimal_int))){
                            System.out.println("MIRROR : " + counter + ". " + decimal_int);
                            counter++;
                            result += Long.valueOf(decimal_int);
                            if(counter == n){
                                return result;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }



    public int convertDecimal(String val, int k){
        // System.out.println("val: " + val);
        int val_len = val.length() - 1;
        int result = 0;

        for(int i = val_len; i >= 0; i--){
            result += Math.pow(k, i) * (val.charAt(i) - '0');
        }
        return result;
    }

    public boolean hasMirror(String str){
        int leftPtr = 0;
        int rightPtr = str.length() - 1;

        while(leftPtr <= rightPtr){
            if(str.charAt(leftPtr) != str.charAt(rightPtr)){
                return false;
            }
            leftPtr++;
            rightPtr--;
        }
        return true;
    }

}
