package dynamics;

import java.util.*;

public class NumberOfWays2MakeChange {
    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(9, 1, 8, 10, 3));
        Integer amount = 12;

        int total = number_of_ways(coins, amount);
        int a = 4;
    }

    static int mod = 1000000007;
    static Integer number_of_ways(ArrayList<Integer> coins, Integer amount) {
        int[][] dpTable = new int[coins.size() + 1][amount + 1];

        for(int i = 0; i < dpTable.length; i++){
            for(int j = 0; j < dpTable[i].length; j++){
                dpTable[i][j] = -1;
            }
        }
        return make_change(coins.size() - 1, coins, amount, dpTable);
    }

    static Integer make_change(int coinIndex, ArrayList<Integer> coins, Integer amount, int[][] dpTable) {
        if(amount < 0 || coinIndex >= coins.size() || coinIndex < 0){
            return 0;
        }

        if(amount == 0){
            return 1;
        }

        if(dpTable[coinIndex][amount] != -1){
            return dpTable[coinIndex][amount];
        }

        int result1 = make_change(coinIndex, coins, amount - coins.get(coinIndex), dpTable);
        int result2 = make_change(coinIndex - 1, coins, amount, dpTable); // bu parayi dikkate alma


        dpTable[coinIndex][amount] = (result1 + result2) % mod;

        return dpTable[coinIndex][amount];
    }
}




//    static Integer number_of_ways(ArrayList<Integer> coins, Integer amount) {
////        Map<Integer, Integer> coinMap = new HashMap<>();
//        return make_change(0, coins, amount);
//    }
//
//
//    static Integer make_change(int coinIndex, ArrayList<Integer> coins, Integer amount) {
//        if(coinIndex >= coins.size()){
//            return 0;
//        }
//        if(amount == 0){
//            return 1;
//        }else if (amount < 0){
//            return 0;
//        }
//
//        int result = make_change(coinIndex, coins, amount - coins.get(coinIndex));
//
//        result = result + make_change(coinIndex + 1, coins, amount);
//
//        return result;
//
//    }