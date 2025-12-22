package study_program.problemSet.string;

import java.util.ArrayList;

public class GenerateAllNumeronyms {
    public static void main(String[] args) {
//        String word = "nailed";
        String word = "a";

        ArrayList<String> result = generate_all_numeronyms(word);

        int a = 4;
    }

    static ArrayList<String> generate_all_numeronyms(String word) {
        if(word.length() <= 2){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currStr = new StringBuilder();
        int endLen = word.length() - 1;

        int maxNumLen = endLen - 1;

        if(maxNumLen <= 0)
            return null;

        int numCounter = 2;

        while(numCounter <= maxNumLen) {
            int numberIndexSlider = 1;
            int sliderEnd = maxNumLen;

            while(numberIndexSlider + numCounter <= endLen ){
                StringBuilder currNumeronym = new StringBuilder();

                String leftPart = word.substring(1, numberIndexSlider);
                String rightPart = word.substring(numberIndexSlider + numCounter, sliderEnd + 1);
                currNumeronym.append(word.charAt(0));
                currNumeronym.append(leftPart);
                currNumeronym.append(numCounter);
                currNumeronym.append(rightPart);
                currNumeronym.append(word.charAt(endLen));
                result.add(currNumeronym.toString());
                numberIndexSlider++;
            }
            numCounter++;
        }

        return result;
    }


}
