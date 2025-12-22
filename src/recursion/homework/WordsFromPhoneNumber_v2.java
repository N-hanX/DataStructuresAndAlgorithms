package recursion.homework;

import java.util.*;

public class WordsFromPhoneNumber_v2 {

    public static void main(String[] args) {
        get_words_from_phone_number("1010101");
    }

    static ArrayList<String> get_words_from_phone_number(String phone_number) {
        Map<Integer, ArrayList<String>> wordSet = new HashMap<>();
        wordSet.put(0, new ArrayList<>(Arrays.asList("")));
        wordSet.put(1, new ArrayList<>(Arrays.asList("")));
        wordSet.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        wordSet.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        wordSet.put(4, new ArrayList<>(Arrays.asList("g","h", "i")));
        wordSet.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        wordSet.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        wordSet.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        wordSet.put(8, new ArrayList<>(Arrays.asList("t","u","v")));
        wordSet.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        ArrayList<String> result = new ArrayList<>();

        createNum(wordSet, phone_number, 0, new StringBuffer(), result);

        return result;
    }

    static void createNum(Map<Integer, ArrayList<String>> wordSet, String phone_number, int curr_ind,
                          StringBuffer permBuilder, ArrayList<String> result ){
        if(curr_ind == phone_number.length()){
            result.add(permBuilder.toString());
            return;
        }

        ArrayList<String> charList = wordSet.get(Character.getNumericValue(phone_number.charAt(curr_ind)));
        for(int i = 0; i < charList.size(); i++){
            String curr_char = charList.get(i);
            permBuilder.append(curr_char);
            createNum(wordSet, phone_number, curr_ind + 1, permBuilder, result);
            if(Character.getNumericValue(phone_number.charAt(curr_ind)) != 0 &&
                    Character.getNumericValue(phone_number.charAt(curr_ind)) != 1)
                permBuilder.deleteCharAt(permBuilder.length() - 1);
        }
    }
}
