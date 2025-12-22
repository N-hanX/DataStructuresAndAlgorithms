package study_lc.study4_i;

import java.util.*;

public class NumberOfDivisibleSubstrings {
    public static void main(String[] args) {
        String word = "asdf";
        int result = countDivisibleSubstrings(word);

        int a = 4;
    }


    public static int countDivisibleSubstrings(String word) {
        total = 0;
        charWithDigitNumber = new HashMap<>();
        charWithDigitNumber.put('a', 1);
        charWithDigitNumber.put('b', 1);

        charWithDigitNumber.put('c', 2);
        charWithDigitNumber.put('d', 2);
        charWithDigitNumber.put('e', 2);

        charWithDigitNumber.put('f', 3);
        charWithDigitNumber.put('g', 3);
        charWithDigitNumber.put('h', 3);

        charWithDigitNumber.put('i', 4);
        charWithDigitNumber.put('j', 4);
        charWithDigitNumber.put('k', 4);

        charWithDigitNumber.put('l', 5);
        charWithDigitNumber.put('m', 5);
        charWithDigitNumber.put('n', 5);

        charWithDigitNumber.put('o', 6);
        charWithDigitNumber.put('p', 6);
        charWithDigitNumber.put('q', 6);

        charWithDigitNumber.put('r', 7);
        charWithDigitNumber.put('s', 7);
        charWithDigitNumber.put('t', 7);

        charWithDigitNumber.put('u', 8);
        charWithDigitNumber.put('v', 8);
        charWithDigitNumber.put('w', 8);

        charWithDigitNumber.put('x', 9);
        charWithDigitNumber.put('y', 9);
        charWithDigitNumber.put('z', 9);

        start_ind_set = new HashSet<>();
        recursion(word, 0);
        return total;
    }

    static Map<Character, Integer> charWithDigitNumber;
    static int total;
    static Set<Integer> start_ind_set;

    public static void recursion(String word, int start_ind){
        if(start_ind == word.length() || start_ind_set.contains(start_ind)){
            return;
        }

        int curr_sum = 0;

        int index_counter = 0;

        for(int i = start_ind; i < word.length(); i++){
            index_counter++;
            curr_sum += charWithDigitNumber.get(word.charAt(i));
            if(curr_sum % index_counter == 0){
                total++;
            }
        }
        recursion(word, start_ind+1);

    }

    // asdf
    // asd
    // sdf
    // asd
    // sd
    // s
    // d
    // a
    // f

}
