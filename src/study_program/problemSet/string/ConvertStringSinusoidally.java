package study_program.problemSet.string;

import java.util.ArrayList;

public class ConvertStringSinusoidally {

    public static void main(String[] args) {
        String s = "InterviewKickstart";

        ArrayList<String> result = convert_string_sinusoidally(s);

        int a = 4;
    }

    static ArrayList<String> convert_string_sinusoidally(String s) {
        int stringLength = s.length();
        ArrayList<String> result = new ArrayList<>();

        StringBuilder firstStr = new StringBuilder();
        int counter = 2;
        while(counter < stringLength){
            if(counter == 2){
                firstStr.append("  ");
            }else{
                firstStr.append("   ");
            }
            firstStr.append(s.charAt(counter));
            counter = counter + 4;
        }

        StringBuilder secondStr = new StringBuilder();
        counter = 1;
        while(counter < stringLength){
            if(counter == 1){
                secondStr.append(" ");
            }else{
                secondStr.append(" ");
            }
            secondStr.append(s.charAt(counter));
            counter = counter + 2;
        }

        StringBuilder thirdStr = new StringBuilder();
        counter = 0;
        while(counter < stringLength){
            if(counter == 0){

            }else{
                thirdStr.append("   ");
            }
            thirdStr.append(s.charAt(counter));
            counter = counter + 4;
        }

        int maxLen = -1;

        if(maxLen < firstStr.length()){
            maxLen = firstStr.length();
        }
        if(maxLen < secondStr.length()){
            maxLen = secondStr.length();
        }
        if(maxLen < thirdStr.length()){
            maxLen = thirdStr.length();
        }

        if(maxLen > firstStr.length()){
            counter = 0;
            while(counter < maxLen - firstStr.length()){
                firstStr.append(" ");
            }
        }

        if(maxLen > secondStr.length()){
            counter = 0;
            while(counter < maxLen - secondStr.length()){
                secondStr.append(" ");
            }
        }

        if(maxLen > thirdStr.length()){
            counter = 0;
            while(counter < maxLen - thirdStr.length()){
                thirdStr.append(" ");
            }
        }

        result.add(firstStr.toString());
        result.add(secondStr.toString());
        result.add(thirdStr.toString());

        return result;
    }

}
