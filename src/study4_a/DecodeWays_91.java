package study4_a;

public class DecodeWays_91 {
    static void main() {
        assert numDecodings("12") == 2 : "Test 1 FAIL";
        assert numDecodings("226") == 3 : "Test 2 FAIL";
        assert numDecodings("06") == 0 : "Test 3 FAIL";
        assert numDecodings("333") == 1 : "Test 4 FAIL";
        assert numDecodings("111111111111111111111111111111111111111111111") == 1836311903 : "Test 5 FAIL";
        assert numDecodings("27") == 1 : "Test 6 FAIL";

    }
    static int decodingCounter;
    public static int numDecodings(String s) {
//        return bruteForceSolution(s);
        return dpSolution(s);
    }

    public static int dpSolution(String s){
        // this is practice. Have not totally internalized yet.
        // Once internalized it would be updated the algorithm to use constant memory
        // by keeping track of only the last two count instead of entire dynamic array.

        // the idea is similar to counting number of different ways in a stair. Every step is a character in the string.
        // Climbing 1 step up -> single digit decode
        // Climbing 2 steps up -> two digit decode (if decoding requirement is met)

        int[] numOfWaysToDecodePrefix = new int[s.length() + 1];

        numOfWaysToDecodePrefix[0] = 1;

        if(s.charAt(0) != '0'){
            numOfWaysToDecodePrefix[1] = 1;
        }

        for(int i = 2; i <= s.length(); i++){
            char currChar = s.charAt(i - 1);
            char prevChar = s.charAt(i - 2);

            // single digit decode
            if(currChar != '0'){
                numOfWaysToDecodePrefix[i] = numOfWaysToDecodePrefix[i - 1];
            }

            // double digit decode
            if(prevChar == '1' || ('6' - currChar >= 0 && prevChar == '2')){
                numOfWaysToDecodePrefix[i] += numOfWaysToDecodePrefix[i - 2];
            }
        }
        return  numOfWaysToDecodePrefix[s.length()];
    }

    public static int bruteForceSolution(String s){
        decodingCounter = 0;
        countTraversingStringIncluding_Excluding(s, 0, false);
        return decodingCounter;
    }


    public static void countTraversingStringIncluding_Excluding(String s, int currInd, boolean isCharacterSecond){
        if(s.length() == currInd){
            // System.out.println("End");
            decodingCounter++;
            return;
        }

        if(isCharacterSecond){
            // System.out.println('6' - s.charAt(currInd));
            if((s.charAt(currInd - 1) == '2' && ('6' - s.charAt(currInd) >= 0)) || s.charAt(currInd - 1) == '1'){
                // System.out.println("Second character currInd: " + currInd);
                countTraversingStringIncluding_Excluding(s, currInd + 1, false); // 12
            }
        }else{
            if(s.charAt(currInd) != '0') {
                // System.out.println("First character currInd: " + currInd);
                countTraversingStringIncluding_Excluding(s, currInd + 1, true); // 1, 2
                // System.out.println("First character - flip currInd: " + currInd);
                if(currInd + 1 != s.length())
                    countTraversingStringIncluding_Excluding(s, currInd + 1, false); //
            }
        }
    }
}
