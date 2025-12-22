package recursion.homework;

import java.util.*;

public class wordsFromPhoneNumber {
     static Map<Integer, List<Character>> phoneWordMap;

    public static void main(String[] args) {
//        getWordsFromPhoneNumber("1234567");
        getWordsFromPhoneNumber("1010101");
    }

    public static List<String> getWordsFromPhoneNumber(String phoneNumber) {
        createPhoneWordHashMap();
        int startInd = 0;
        List<String> allResults = new ArrayList<>();
        List<Integer>  numberArr = createNumberArr(phoneNumber);
        String str = "";
        wordPhoneCreateHelper(numberArr, startInd, allResults, str);

        if(allResults.size() == 1 && allResults.get(0).equals("") ) {
            allResults.set(0, "-1");
        }
        return allResults;
    }

    public static void wordPhoneCreateHelper(List<Integer> numberArr, int currInd, List<String> allResults,
                                             String str){
        if(numberArr.size() == currInd){
            allResults.add(str);
            return;
        }

        int currNumber = numberArr.get(currInd);
        List<Character>  currWords = phoneWordMap.get(currNumber);
        if(currWords.size() != 0){
            for(int k = 0; k < currWords.size(); k++){
                str = str + currWords.get(k);
                wordPhoneCreateHelper(numberArr, currInd + 1, allResults, str);
                str = str.substring(0, str.length() - 1);
            }
        }else{
            wordPhoneCreateHelper(numberArr, currInd + 1, allResults, str);
        }

    }

    public static List<Integer> createNumberArr(String phoneNumber){
        List<Integer> numberArr = new ArrayList<>();

        for(int i = 0; i < phoneNumber.length(); i++){
            numberArr.add(Character.getNumericValue(phoneNumber.charAt(i)));
        }
        return numberArr;
    }

    public static void createPhoneWordHashMap(){
        phoneWordMap = new HashMap<>();
        phoneWordMap.put(0, Collections.emptyList());
        phoneWordMap.put(1, Collections.emptyList());
        phoneWordMap.put(2, Arrays.asList('a', 'b', 'c'));
        phoneWordMap.put(3, Arrays.asList('d', 'e', 'f'));
        phoneWordMap.put(4, Arrays.asList('g', 'h', 'i'));
        phoneWordMap.put(5, Arrays.asList('j', 'k', 'l'));
        phoneWordMap.put(6, Arrays.asList('m', 'n', 'o'));
        phoneWordMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        phoneWordMap.put(8, Arrays.asList('t', 'u', 'v'));
        phoneWordMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }
}
