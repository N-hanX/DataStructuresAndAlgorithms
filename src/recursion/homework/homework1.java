package recursion.homework;

import java.util.ArrayList;

public class homework1 {
    public static void main(String[] args) {
        String s = "a1b2";
        char[] chars = new char[s.length()];

        for(int i = 0; i< s.length(); i++){
            chars[i] = s.charAt(i);
        }
        String currentStr = "";
        ArrayList<String> results = new ArrayList<>();
        printLowerAndUpperCases(currentStr, chars, 0, results);
        int a = 5;
    }

    public static void printLowerAndUpperCases(String currentStr, char[] chars, int currentInd, ArrayList<String> results ) {
        if (currentInd == chars.length) {
            System.out.println(currentStr);
            results.add(currentStr);
            return;
        }

        if (Character.isDigit(chars[currentInd])) {
            printLowerAndUpperCases(currentStr + chars[currentInd], chars, currentInd + 1, results);
        } else {
            printLowerAndUpperCases(currentStr + Character.toLowerCase(chars[currentInd]), chars, currentInd + 1, results);
            printLowerAndUpperCases(currentStr + Character.toUpperCase(chars[currentInd]), chars, currentInd + 1, results);
        }
        return;
    }
}
