package study_lc;

public class sqrtProblem {
    public static void main(String[] args) {
        int num = 2147395599;
        int start = 0;
        int end = num;

        int result = getSqrt( num, start, end);
        System.out.println(result);
    }

    public static int getSqrt(int num, int start, int end){
        long middle = start + (end - start) / 2;

        long currResult = middle * middle;
        if (currResult == Integer.MAX_VALUE ){
            return getSqrt(num, start, (int)middle);
        }

        if(start == middle || end == middle){
            if(middle * middle > num){
                return start;
            }else{
                return (int)middle;
            }
        }

        if(middle * middle > num){
            return getSqrt(num, start, (int)middle);
        }else if(middle * middle < num){
            return getSqrt(num, (int)middle, end);
        }else{
            return (int)middle;
        }
    }
}
