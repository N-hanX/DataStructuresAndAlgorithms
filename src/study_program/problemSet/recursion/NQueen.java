package study_program.problemSet.recursion;

import java.util.ArrayList;

public class NQueen {
    public static void main(String[] args) {
        int n = 5;
        find_all_arrangements(n);
        int a;
    }


    static ArrayList<ArrayList<String>> find_all_arrangements(Integer n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        createArrangementForEachLine(new ArrayList<String>(), result, n, 0);
        return result;
    }

    static void createArrangementForEachLine(ArrayList<String> currResult,
                                             ArrayList<ArrayList<String>> allResult, int size_of_line, int currLine){
        if(currLine == size_of_line){
            allResult.add(new ArrayList<>(currResult));
            return;
        }

        int curr_q_position = 0;
        while(curr_q_position < size_of_line){
            StringBuilder currLineBuilder = new StringBuilder();

            for(int i = 0; i < size_of_line; i++){
                if( i == curr_q_position){
                    currLineBuilder.append('q');
                }else{
                    currLineBuilder.append('-');
                }
            }
            // check is it safe to create this string
            //
            if(isItSafe(currLineBuilder, currResult)){
                currResult.add(currLineBuilder.toString());
                createArrangementForEachLine(currResult, allResult, size_of_line, currLine + 1);
                currResult.remove(currResult.size() - 1);
            }

            curr_q_position++;
        }
    }

    public static Boolean isItSafe(StringBuilder currLineBuilder, ArrayList<String> currResult){
        if(currResult.isEmpty())
            return true;

        for(int currCharIndex = 0; currCharIndex < currLineBuilder.length(); currCharIndex++){
            int numOfBuiltLine = currResult.size();

            if(currLineBuilder.charAt(currCharIndex) == 'q'){
                // once dikey olarak bak
                int countLine = 0;

                while(countLine < numOfBuiltLine){
                    if(currResult.get(countLine).charAt(currCharIndex) == 'q'){
                        return false;
                    }
                    countLine++;
                }

                // carpraz olarak bak bir oncekine

                int charIndexDiagonal = currCharIndex - 1;
                int lineIndexDiagonal = numOfBuiltLine - 1;

                // bir sol ust carpraz
                // bir sag ust carpraz

                while(charIndexDiagonal >= 0 && lineIndexDiagonal >= 0){
                    if(currResult.get(lineIndexDiagonal).charAt(charIndexDiagonal) == 'q'){
                        return false;
                    }

                    charIndexDiagonal--;
                    lineIndexDiagonal--;
                }


                charIndexDiagonal = currCharIndex + 1;
                lineIndexDiagonal = numOfBuiltLine - 1;

                while(charIndexDiagonal < currLineBuilder.length() && lineIndexDiagonal >= 0){
                    if(currResult.get(lineIndexDiagonal).charAt(charIndexDiagonal) == 'q'){
                        return false;
                    }

                    charIndexDiagonal++;
                    lineIndexDiagonal--;
                }


//                if((currCharIndex + 1 < currLineBuilder.length()) && (currCharIndex == 0 || numOfBuiltLine != 0)){
//                    if(currResult.get(numOfBuiltLine - 1).charAt(currCharIndex + 1) == 'q'){
//                        return false;
//                    }
//                }
//
//                if(currCharIndex >= 1 && (currCharIndex == currLineBuilder.length() - 1 || numOfBuiltLine != 0)){
//                    if(currResult.get(numOfBuiltLine - 1).charAt(currCharIndex - 1) == 'q'){
//                        return false;
//                    }
//                }
//
//                if((currCharIndex + 1 < currLineBuilder.length()) &&
//                        (currCharIndex > 0 ) && currCharIndex + 1 < currLineBuilder.length() && numOfBuiltLine > 0){
//                    if(currResult.get(numOfBuiltLine - 1).charAt(currCharIndex - 1) == 'q'){
//                        return false;
//                    }
//                    if(currResult.get(numOfBuiltLine - 1).charAt(currCharIndex + 1) == 'q'){
//                        return false;
//                    }
//                }
            }
        }
        return true;
    }
}
