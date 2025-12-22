package study_lc;

import java.util.*;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";

        List<String> result = letterCombinations(digits);

        int a = 4;
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> lettersByDigit = new HashMap<>();
        lettersByDigit.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        lettersByDigit.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        lettersByDigit.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));

        lettersByDigit.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        lettersByDigit.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        lettersByDigit.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));

        lettersByDigit.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        lettersByDigit.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        List<String> result = new ArrayList<>();

        createLetterCombination(0, digits, result, new StringBuilder(), lettersByDigit);
        return result;
    }

    public static void createLetterCombination(int digit_ind, String digits, List<String> result,
                                               StringBuilder digitBuilder, Map<Integer, List<Character>> lettersByDigit){
        if(digits.length() == 0){
            return;
        }

        if(digits.length() <= digit_ind){
            result.add(digitBuilder.toString());
            return;
        }

        int currDigit = digits.charAt(digit_ind) - '0';

        for(int i = 0; i < lettersByDigit.get(currDigit).size(); i++){
            char currLetter = lettersByDigit.get(currDigit).get(i);
            digitBuilder.append(currLetter);
            createLetterCombination(digit_ind + 1, digits, result, digitBuilder, lettersByDigit);
            digitBuilder.deleteCharAt(digitBuilder.length() - 1);
        }
    }
}
