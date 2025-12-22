package study_program.problemSet.string;

import java.util.*;

public class IndicesOfWordsInTextString {
    public static void main(String[] args) {
//        String text = "you are very very smart";
//        ArrayList<String> words = new ArrayList<>(Arrays.asList("you", "are", "very", "handsome"));
//        String text = "hhhH";
//        ArrayList<String> words = new ArrayList<>(Arrays.asList("hhhH", "HHHH", "hhhh", "hhh", "hhhHh"));

//        {

        String text = "jdaadakr 141y 912u108 141y141y phIH#I$34h lr 141y hrh#YriQhi rh iuhr3iR3qh rih rRhq3r3bkr ?b #GR3ri g3r3";
        ArrayList<String>  words = new ArrayList<>(Arrays.asList("hrhabrj", "qrqbrkj", "$", "g3r3", "141y"));

        ArrayList<ArrayList<Integer>> result = find_words(text, words);
        int a = 5;
    }

    static ArrayList<ArrayList<Integer>> find_words(String text, ArrayList<String> words) {
        ArrayList<String> textSubstrings = new ArrayList<>();
        ArrayList<Integer> textSubstringsIndices = new ArrayList<>();

        int startInd = 0;
        while(startInd < text.length()){
            int iterator = startInd;
            int endInd = text.length() - 1;
            while(iterator < text.length() && text.charAt(iterator) != ' ' ){
                iterator++;
                if(iterator == text.length() || text.charAt(iterator) == ' ')
                    endInd = iterator;
            }
            textSubstrings.add(text.substring(startInd, endInd));
            textSubstringsIndices.add(startInd);
            startInd = iterator + 1;
        }

        Map<Character, Integer> charMap = new HashMap<>();

        char currChar = ' ';
        for(int i = 0; i < 97; i++){
            charMap.put(currChar, i);
            currChar++;
        }

        Set<Integer> wordLen = new HashSet<>();
        Map<Integer, ArrayList<Integer>> wordLenMap = new HashMap<>();

        Set<Integer> hashValueSet = new HashSet<>();
        Map<Integer, ArrayList<Integer>> hashValueMap = new HashMap<>();

        for(int i = 0; i < words.size(); i++){
            int currHashValue = calculateHashValue(words.get(i), charMap);
            int currLen = words.get(i).length();

            wordLen.add(currLen);
            hashValueSet.add(currHashValue);

            if(hashValueMap.containsKey(currHashValue)){
                ArrayList<Integer> hashList = hashValueMap.get(currHashValue);
                hashList.add(i);
            }else{
                ArrayList<Integer> hashList = new ArrayList<>();
                hashList.add(i);
                hashValueMap.put(currHashValue, hashList);
            }

            if(wordLenMap.containsKey(currLen)){
                ArrayList<Integer> lenList = wordLenMap.get(currLen);
                lenList.add(i);
            }else{
                ArrayList<Integer> lenList = new ArrayList<>();
                lenList.add(i);
                wordLenMap.put(currLen, lenList);
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < words.size(); i++){
            result.add(new ArrayList<>());
        }

        for(int i = 0; i < textSubstrings.size(); i++){

            String currSubstring = textSubstrings.get(i);
            int hashValueOfCurrSubstring = calculateHashValue(currSubstring, charMap);

//                System.out.println("currString: " + currSubstring);

            if(hashValueSet.contains(hashValueOfCurrSubstring)){
                ArrayList<Integer> wordIndices = hashValueMap.get(hashValueOfCurrSubstring);

                for(int wordIndexIterator = 0; wordIndexIterator < wordIndices.size(); wordIndexIterator++){
                    int wordIndex = wordIndices.get(wordIndexIterator);
                    String currWord = words.get(wordIndex);

                    if(currWord.equals(currSubstring)){
                        ArrayList<Integer> wordResult = result.get(wordIndex);
                        wordResult.add(textSubstringsIndices.get(i));
                    }
                }
            }
        }


        for(int i = 0; i < result.size(); i++){
            ArrayList<Integer> theList = result.get(i);
            if(theList.isEmpty()){
                theList.add(-1);
            }
        }

        return result;
    }

    public static int calculateHashValue(String text, Map<Character, Integer> charMap){
        int hashValue = 0;
        int baseValue = charMap.size();
        int primeValue = 97;

        for(int i = 0; i < text.length(); i++){
            char currChar = text.charAt(i);

            int charValue = charMap.get(currChar);

            hashValue = hashValue + (charValue * (int)Math.pow(baseValue, text.length() - i - 1) % primeValue);
        }
        return hashValue;
    }
}
