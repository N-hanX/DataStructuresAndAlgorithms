package study_lc.study4_i;


public class LexicographicallySmallestStringAfterPerformingOperation {
    public static void main(String[] args) {
        String s = "acbbc";
//        String s = "bab";
        String result = smallestString(s);

        int a = 4;
    }

    public static String smallestString(String s) {
        if(s.isEmpty())
            return null;

        StringBuilder result = new StringBuilder();

        // edge case if everything is a
        int uninterrupted_num_of_a_in_start = 0;
        int counter = 0;

        while(counter < s.length()){
            char curr_char = s.charAt(counter);
            if(curr_char == 'a'){
                uninterrupted_num_of_a_in_start++;
            }else{
                break;
            }
            counter++;
        }

        for(int i = 0; i < uninterrupted_num_of_a_in_start; i++){
            result.append('a');
        }

        boolean changable = true;
        for(int i = uninterrupted_num_of_a_in_start; i < s.length(); i++){
            char curr_char = s.charAt(i);
            if(curr_char == 'a'){
                result.append(curr_char);
                changable = false;
            }else{
                if(!changable){
                    result.append(curr_char);
                }else{
                    result.append((char)(curr_char - 1));
                }
            }
        }

        if(uninterrupted_num_of_a_in_start == s.length()){
            result = new StringBuilder();
            for(int i = 0; i < s.length() - 1; i++){
                result.append('a');
            }
            result.append('z');
        }

        return result.toString();
    }
}
