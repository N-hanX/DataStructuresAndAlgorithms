package study_lc.study4_c;

public class CheckIfBinaryStringHasAtMostOneSegmentofOnes_1784 {
    public static void main(String[] args) {
//        boolean result = checkOnesSegment("1101");
//        boolean result = checkOnesSegment("10");
//        boolean result = checkOnesSegment("000");
        boolean result = checkOnesSegment("1010");
        int a = 4;

    }

    public static boolean checkOnesSegment(String s) {
        if(s.equals("1")){
            return true;
        }

        int str_len = s.length();
        boolean segmentForOnes = false;

        char prevChar = s.charAt(0);
        if(prevChar == '0'){
            return false;
        }

        if(prevChar == '1' && s.charAt(1) == '0'){
            segmentForOnes = true;
        }

        int index = 1;
        while(index < str_len){
            char currChar = s.charAt(index);

            if(!segmentForOnes && currChar == prevChar && prevChar == '1'){
                segmentForOnes = true;

                while(currChar == prevChar && prevChar == '1' && index < s.length()){
                    currChar = s.charAt(index);
                    prevChar = currChar;
                    index++;
                }

                continue;
            }
            if(segmentForOnes && currChar == '1')
                return false;
            prevChar = currChar;
            index++;
        }
        return segmentForOnes;
    }
}
