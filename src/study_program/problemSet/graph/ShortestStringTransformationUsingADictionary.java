package study_program.problemSet.graph;

import java.util.*;

public class ShortestStringTransformationUsingADictionary {
    public static void main(String[] args) {
//        ArrayList<String> words = new ArrayList<>(Arrays.asList("cat", "hat", "bad", "had"));
//        String start = "bat";
//        String stop = "had";

//        ArrayList<String> words = new ArrayList<>();
//        String start = "bbb";
//        String stop = "bbc";

//        ArrayList<String> words = new ArrayList<>();
//        String start = "zzzzzz";
//        String stop = "zzzzzz";

//        ArrayList<String> words = new ArrayList<>(Arrays.asList("ggggnn", "gggnnn", "gggggn", "ggnnnn", "gnnnnn"));
//        String start = "gggggg";
//        String stop = "nnnnnn";

//        ArrayList<String> words = new ArrayList<>(Arrays.asList("poon", "plee", "same", "poie", "plie", "poin"));
//        String start = "toon";
//        String stop = "plea";

//        ArrayList<String> words = new ArrayList<>(Arrays.asList("a", "w", "y", "q", "r", "w", "q", "i", "y", "y", "s", "v", "o", "y", "o", "o", "y", "o", "t", "v", "n", "c", "q", "g", "y", "s", "w", "m", "z", "y", "h", "h", "t", "d", "e", "b", "e", "y", "g", "i", "p", "b", "g", "v", "w", "s", "h", "u", "u", "o", "e", "a", "a", "x", "e", "p", "e", "k", "d", "r", "l", "w", "a", "w", "d", "k", "q", "y", "f", "g", "l", "n", "f", "f", "n", "z", "g", "z", "w", "p", "r", "h", "n", "a", "g", "c", "y", "o", "k", "i", "s", "k", "v", "d", "i", "e", "x", "k", "o", "a", "g", "l", "s", "q", "n", "s", "w", "x", "x", "d", "g", "u", "r", "y", "c", "s", "v", "d", "z", "u", "d", "a", "f", "v", "u", "l", "f", "t", "k", "b", "u", "w", "k", "t", "x", "e", "k", "i", "r", "l", "u", "w", "f", "o", "w", "z", "p", "v", "w", "x", "b", "o", "a", "e", "k", "v", "b", "i", "i", "q", "i", "l", "p", "f", "g", "b", "g", "t", "y", "z", "a", "s", "j", "a", "d", "e", "x", "q", "x", "n", "t", "o", "m", "v", "a", "o", "d", "x", "h", "m", "a", "a", "n", "c", "r", "a", "a", "m", "s", "c", "j", "t", "s", "i", "f", "g", "m", "p", "t", "r", "x", "b", "q", "k", "p", "q", "h", "c", "n", "q", "w", "k", "z", "c", "s", "a", "s", "q", "o", "c", "z", "e", "g", "e", "l", "g", "w", "t", "t", "t", "l", "u", "o", "t", "w", "d", "o", "k", "c", "s", "y", "f", "g", "m", "p", "j", "s", "n", "j"));
//        String start = "b";
//        String stop = "h";


        ArrayList<String> words = new ArrayList<>(Arrays.asList("aaa"));
        String start = "baa";
        String stop = "aab";


        ArrayList<String> result = string_transformation(words, start, stop);
        int a;

    }


    static ArrayList<String> string_transformation(ArrayList<String> words, String start, String stop) {
        Set<String> visited = new HashSet<>();

        Set<String> edit_words = new HashSet<>();

        for(int i = 0; i < words.size(); i++){
            edit_words.add(words.get(i));
        }

        words = new ArrayList<>();

        Iterator iterator = edit_words.iterator();

        while(iterator.hasNext()){
            words.add((String) iterator.next());
        }


        Map<String, ArrayList<String>> dictMap = new HashMap<>();

        for(int i = 0; i < words.size(); i++){
            String currWord = words.get(i);

            ArrayList<String> neighborDicts = new ArrayList<>();
            for(int j = 0; j < words.size(); j++){
                if(i != j){
                    if(checkDifferenceCondition(currWord, words.get(j)))
                        neighborDicts.add(words.get(j));
                }
                dictMap.put(currWord, neighborDicts);
            }
        }

        result = new ArrayList<>();
        ArrayList<String> currResult = new ArrayList<>();
        traverse_dictionary(dictMap, start, stop, visited, "", currResult, 0, words);
        if(result.isEmpty()){
            result.add("-1");
        }
        int a = 5;
        return result;
    }

    static Boolean checkDifferenceCondition(String a, String b){
        int count = 0;
        int numOfDiff = 0;

        while(count < a.length()){
            if(a.charAt(count) != b.charAt(count)){
                numOfDiff++;
                if(numOfDiff > 1){
                    break;
                }
            }
            count++;
        }
        if(numOfDiff == 1){
            return true;
        }
        return false;
    }

    static ArrayList<String> result;
    static void traverse_dictionary(Map<String, ArrayList<String>> dictMap, String start, String stop,
                                    Set<String> visited, String intermediateString,
                                    ArrayList<String> currResult, int isItStart, ArrayList<String> words) {

        if(isItStart == 0){// suan starttayiz
            if(checkDifferenceCondition(start, stop)){
                result.add(start);
                result.add(stop);
                return;
            }

            currResult.add(start);
            boolean found = false;
            for(int i = 0; i < words.size(); i++){
                if(checkDifferenceCondition(words.get(i), start)){
                    currResult.add(words.get(i));
                    visited.add(words.get(i));
                    traverse_dictionary(dictMap, start, stop, visited, words.get(i), currResult,
                            isItStart + 1, words);
                    currResult.remove(currResult.size() - 1);
                    visited.remove(words.get(i));
                    found = true;
                }
            }
            if(found == false){
                result.add("-1");
                return;
            }
        } else{
            // eger ki intermediateString stop ile 1 ise edge case
            if(checkDifferenceCondition(stop, intermediateString)){
                currResult.add(stop);
                if(result.isEmpty() || result.size() > currResult.size()){
                    result = new ArrayList<>(currResult);
                }
                currResult.remove(currResult.size() - 1);// cikar en son elemani
                return;
            }

            if(currResult.size() > stop.length() + 1){
                return;
            }

            // degilse intermediateString'in tum komsularini karsilastir
            ArrayList<String> neighbors = dictMap.get(intermediateString);
            for(int i = 0; i < neighbors.size(); i++){
                String currComparedWord = neighbors.get(i);

                if(!visited.contains(currComparedWord)){
                    currResult.add(currComparedWord);
                    visited.add(currComparedWord);
                    traverse_dictionary(dictMap, start, stop, visited, currComparedWord,
                            currResult, isItStart + 1, currResult);
                    currResult.remove(currResult.size() - 1);
                    visited.remove(currComparedWord);
                }
            }
        }
    }
}
