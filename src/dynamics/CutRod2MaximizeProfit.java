package dynamics;

import java.util.*;

public class CutRod2MaximizeProfit {
    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>(Arrays.asList(1, 5, 8, 9));
        int result = get_maximum_profit(prices);
        int a = 5;
    }

    static Integer get_maximum_profit(ArrayList<Integer> price) {
        Map<Integer, Integer> maxPriceMap = new HashMap<>();
        return get_maximum_profit(price.size(), price, maxPriceMap);
    }

    static int g(List<Integer> prices, int cutSize) {
        return prices.get(cutSize - 1);
    }

    static Integer get_maximum_profit(int n, ArrayList<Integer> prices, Map<Integer, Integer> maxPriceMap) {
        if(n <= 0){
            return 0;
        }
        int solution = 0;

        for (int k = 1; k <= n; k++) {
            if(maxPriceMap.containsKey((n - k))){
                solution = Math.max(solution, maxPriceMap.get(n - k) + g(prices, k));
            }else{
                solution = Math.max(solution, get_maximum_profit(n - k, prices, maxPriceMap) + g(prices, k));
            }
        }
        maxPriceMap.put(n, solution);
        return solution;
    }
}
