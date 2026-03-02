package study4_a;

public class ReverseInteger_7 {
    static void main() {
        // Test 1
        assert reverse(123) == 321 : "Test 1 FAIL";

        // Test 2
        assert reverse(-123) == -321 : "Test 2 FAIL";

        // Test 3
        assert reverse(120) == 21 : "Test 3 FAIL";

        // Test 4
        assert reverse(1534236469) == 0 : "Test 4 FAIL";

        // Test 5
        assert reverse(-2147483648) == 0 : "Test 5 FAIL";

        System.out.println("All tests passed!");
    }

    public static int reverse(int x) {
        long result = 0;
        int divisionResult = x;

        while(divisionResult != 0){
            int modResult = divisionResult % 10;
            divisionResult = divisionResult / 10;
            result += modResult;
            if(divisionResult != 0){
                if(result * 10 > Integer.MAX_VALUE || result * 10 < Integer.MIN_VALUE)
                    return 0;
                result *= 10;
            }
        }
        return (int)result;
    }
}
