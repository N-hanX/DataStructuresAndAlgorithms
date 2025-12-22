package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PowerRecursion {

    static Map<Long, Long> powerMap = new HashMap<>();
    static Long result = 1L;
    static long remaining;

    static Stack<Long> powerStack = new Stack<>();

    public static void main(String[] args) {
        int a = calculate_power(3L, 7L);
        System.out.println(a);
        int aa = 4;
    }

    static Integer calculate_power(Long a, Long b) {
        result = a;
        remaining = b - 1;
        powerStack.add(1L);
        powerMap.put(1L, a);

        recursive_calculation(a, b);
        long mod_l = result % 1000000007L;
        return (int) mod_l;
    }

    static void recursive_calculation(Long a, Long b){
        while(remaining > 0) {
            // count nedir?

            Long maxVal = powerStack.peek();

            // hangi value alacagimizi bulalim carpmak icin.
            Long overA = maxVal * 2;
            long currVal = powerMap.get(maxVal) * powerMap.get(maxVal);

            if(remaining - maxVal > maxVal){
                powerStack.add(overA);
                powerMap.put(overA, currVal);
            }

            while (remaining < maxVal) {
                powerStack.pop();
                maxVal = powerStack.peek();
            }


            maxVal = powerStack.peek();
            result = (result * powerMap.get(maxVal)) % 1000000007L;
            remaining = remaining - maxVal;
        }
    }

}
