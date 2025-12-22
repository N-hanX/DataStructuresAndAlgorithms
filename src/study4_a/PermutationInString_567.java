package study4_a;

public class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] str1_arr = new int[26];
        int[] str2_curr_arr = new int[26];

        for(int i = 0; i < s1.length(); i++){
            str1_arr[s1.charAt(i) - 'a']++;
        }

        // sliding window yapsak?

        int start_ind = 0;
        for(int i = 0; i < s1.length(); i++){
            str2_curr_arr[s2.charAt(i) - 'a']++;
        }

        if(compareArray(str1_arr, str2_curr_arr))
            return true;

        for(int curr_end_ind = s1.length(); curr_end_ind < s2.length(); curr_end_ind++){ // the last possible start index of s2
            str2_curr_arr[s2.charAt(start_ind) - 'a']--;
            str2_curr_arr[s2.charAt(curr_end_ind) - 'a']++;

            if(compareArray(str1_arr, str2_curr_arr))
                return true;

            start_ind++;
        }
        return false;
    }

    public boolean compareArray(int[] str_arr1, int[] str_arr2){
        for(int i = 0; i < 26; i++){
            if(str_arr1[i] != str_arr2[i]){
                return false;
            }
        }
        return true;
    }

    public String create_code(int[] str_arr){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str_arr.length; i++){
            // System.out.println(str_arr[i]);
            result.append(str_arr[i]).append("_");
        }
        return result.toString();
    }
}
