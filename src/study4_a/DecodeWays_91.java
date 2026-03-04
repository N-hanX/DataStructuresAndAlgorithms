package study4_a;

public class DecodeWays_91 {
    static void main() {
        assert numDecodings("12") == 2 : "Test 1 FAIL";
        assert numDecodings("226") == 3 : "Test 2 FAIL";
        assert numDecodings("06") == 0 : "Test 3 FAIL";
        assert numDecodings("333") == 2 : "Test 4 FAIL";
        assert numDecodings("111111111111111111111111111111111111111111111") == 1836311903 : "Test 5 FAIL";

    }
    static int decodingCounter;
    public static int numDecodings(String s) {
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
                countTraversingStringIncluding_Excluding(s, currInd + 1, !isCharacterSecond); // 12
            }
            else
                return;
        }else{
            if(s.charAt(currInd) == '0') {
                return;
            }else{
                // System.out.println("First character currInd: " + currInd);
                countTraversingStringIncluding_Excluding(s, currInd + 1, isCharacterSecond); // 1, 2
                // System.out.println("First character - flip currInd: " + currInd);
                if(currInd + 1 != s.length())
                    countTraversingStringIncluding_Excluding(s, currInd + 1, !isCharacterSecond); //
            }
        }
    }
}
