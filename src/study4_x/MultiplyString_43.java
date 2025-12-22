package study4_x;

public class MultiplyString_43 {
    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "34";

        String result = multiply(num1, num2);
        int a;
    }

    public static String multiply(String num1, String num2){
        int[] result_digit = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--){
            int curr_digit_1 = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j--){
                int curr_digit_2 = num2.charAt(j) - '0';

                int pos1 = i + j + 1;
                int pos2 = i + j;

                int result = curr_digit_1 * curr_digit_2 + result_digit[pos1];
                result_digit[pos1] = result % 10; // the value
                result_digit[pos2] = result / 10;
            }
        }

        StringBuilder the_result = new StringBuilder();
        for(int i = 0; i < result_digit.length; i++){
            if(the_result.isEmpty() && result_digit[i] == 0){
                continue;
            }else
                the_result.append(result_digit[i]);
        }
        return the_result.toString();
    }
}
