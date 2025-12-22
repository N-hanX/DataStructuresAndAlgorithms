package study_program.problemSet.recursion;

public class Power {
    public static void main(String[] args) {
        long a = 10000;
        long b = 10000000;

        Integer result = calculate_power(a, b);
        int v = 4;
    }

    static int Mod = 1000000007;

    static Integer calculate_power(Long a, Long b) {

        if(b == 1L)
            return (int)(a % Mod);
        if(b == 0)
            return 1;

        int temp = calculate_power(a, b / 2);

        int result = 1;

        if( b % 2 == 0)
            result = (result *temp * temp) % Mod;
        else
            result = (int)((result * temp * temp * a) % Mod);

        return result;
    }

}
