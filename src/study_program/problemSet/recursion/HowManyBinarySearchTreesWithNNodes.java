package study_program.problemSet.recursion;

public class HowManyBinarySearchTreesWithNNodes {
    public static void main(String[] args) {
        int n = 3;

        Long counter = bst_counter(n);

        int a = 5;
    }

    public static Long bst_counter(int n){
        if( n == 0){
            return 1L;
        }

        Long counter = 0L;
        for(int i = 0; i < n; i++){
            int left = i;
            int right = n - i - 1;

            counter += bst_counter(left) * bst_counter(right);
        }
        return counter;
    }
}
