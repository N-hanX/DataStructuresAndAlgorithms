package study_lc;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int num = 653;
//        int num = 12345;
//        int num = 1234567;

        String result = numberToWords(num);
        int a = 4;
    }

    static Map<Integer,String> numbers_converter = new HashMap<Integer,String>();
    static Map<Integer,String> number_place = new HashMap<Integer,String>();
    static Map<Integer,String> number_2nd = new HashMap<Integer,String>();

    public static String numberToWords(int num) {
        int the_num = num;
        createWordMap();
        StringBuilder word = new StringBuilder();

        while(num != 0){
            int curr_bolum = num / 1000;

            if(curr_bolum < 1000){
                int bolum = curr_bolum;

                while(bolum != 0){
                    if(bolum != the_num){
                        word.append(" ");
                    }
                    if(bolum / 100 > 0){
                        int temp = bolum / 100;
                        String number = numbers_converter.get(temp);
                        word.append(number);
                        word.append(" ");
                        word.append("Hundred");
                        bolum = bolum % 100;
                    }else {
                        if(numbers_converter.containsKey(bolum)){
                            word.append(numbers_converter.get(bolum));
                            bolum = 0;
                        }else{
                            int temp = bolum / 10;
                            String number = number_2nd.get(temp);
                            word.append(number);
                            bolum = bolum % 10;
                        }
                    }
                }
            }else{

            }
            num = num / 1000;
        }
        return word.toString();
    }

    public static void createWordMap(){
        numbers_converter.put(0,"Zero");
        numbers_converter.put(1,"One");
        numbers_converter.put(2,"Two");
        numbers_converter.put(3,"Three");
        numbers_converter.put(4,"Four");
        numbers_converter.put(5,"Five");
        numbers_converter.put(6,"Six");
        numbers_converter.put(7,"Seven");
        numbers_converter.put(8,"Eight");
        numbers_converter.put(9,"Nine");
        numbers_converter.put(10,"Ten");
        numbers_converter.put(11,"Eleven");
        numbers_converter.put(12,"Twelve");
        numbers_converter.put(13,"Thirteen");
        numbers_converter.put(14,"Fourteen ");
        numbers_converter.put(15,"Fifteen");
        numbers_converter.put(16,"Sixteen");
        numbers_converter.put(17,"Seventeen");
        numbers_converter.put(18,"Eighteen");
        numbers_converter.put(19,"Nineteen");
        number_place.put(3,"Hundred");
        number_place.put(4,"Thousand");
        number_place.put(7,"Million");
        number_place.put(11,"Billion");
        number_2nd.put(2,"Twenty");
        number_2nd.put(3,"Thirty");
        number_2nd.put(4,"Forty");
        number_2nd.put(5,"Fifty");
        number_2nd.put(6,"Sixty");
        number_2nd.put(7,"Seventy");
        number_2nd.put(8,"Eighty");
        number_2nd.put(9,"Ninty");
    }
}
