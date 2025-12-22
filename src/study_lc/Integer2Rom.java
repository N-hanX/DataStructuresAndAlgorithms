package study_lc;

import java.util.HashMap;

public class Integer2Rom {
    static HashMap<Integer, String> romanMap = new HashMap<>();
    static int[] romanArr = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    static StringBuilder strBuilder = new StringBuilder();

    public static void main(String[] args) {
        String str = intToRoman(58);
        int a = 5;
    }

    public static String intToRoman(int num) {
        createHashMap();
        int remaining = num;

        while(remaining > 0){
            int theRomanNumberInd = findTheCurrentRomanInd(remaining);
            int theRomanNumber = romanArr[theRomanNumberInd];

            int divideResult = 1;
            if(theRomanNumber <= remaining){ // toplama yapilacak
                divideResult = remaining / theRomanNumber;

                for(int i = 0; i <  divideResult; i++){
                    strBuilder.append(romanMap.get(theRomanNumber));
                }

                remaining = remaining - theRomanNumber * divideResult;
                System.out.println(remaining);
            }
        }
        return strBuilder.toString();
    }

    public static int findTheCurrentRomanInd(int num){
        int i;
        for( i = romanArr.length - 1; i >= 0; i--){
            int currRoman = romanArr[i];

            if(currRoman > num){
                continue;
            }else{
                // toplama condition
                int divideResult = num / currRoman;

                if (divideResult <= 3){
                    return i;
                }
            }
        }
        return 0;
    }


    public static void createHashMap(){
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
    }
}
