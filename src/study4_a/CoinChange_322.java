package study4_a;

public class CoinChange_322 {
    static void main() {
        // TEST1
        int[] coins = new int[]{1,2,5};
        int amount  = 11;
        int result = coinChange(coins, amount);

////        // TEST2
//        int[] coins = new int[]{2};
//        int amount  = 3;
//        int result = coinChange(coins, amount);
//
//        // TEST3
//        int[] coins = new int[]{1};
//        int amount  = 0;
//        int result = coinChange(coins, amount);


        int end = 0;
    }

    public static int coinChange(int[] coins, int amount) {
        int numOfCoinsDenomination = coins.length+1; // including no denomination
        int numOfAmount = amount + 1; // including zero amount
        int[][] dpTable = new int[numOfCoinsDenomination][numOfAmount];


        // each row represents a money denomination
        // fill the first row -1. which means since the first row represents no money denomination, it is impossible to achieve an amount
        for(int curr_amount = 0; curr_amount < numOfAmount; curr_amount++){
            dpTable[0][curr_amount] = -1;
        }

        // each column represents an amount
        // first column represents the amount of 0
        for(int i = 0; i < numOfCoinsDenomination; i++){
            dpTable[i][0] = 0;
        }


        // the matrix states represent the minimum number of money denomination till an amount
        // the matrix states puts forward the minimum number achieved this amount either the previous money denomination
        // or (the current amount of money minus the current class denomination )plus + 1
        // it sounds not clear, or confusing.
        //
        for(int curr_money_denom_ind = 1; curr_money_denom_ind < numOfCoinsDenomination; curr_money_denom_ind++){
            for(int curr_amount = 1; curr_amount < numOfAmount; curr_amount++){
                int previousOptimalNumOfCoinForCurrAmount = dpTable[curr_money_denom_ind-1][curr_amount];
                int optimalNumForPreviousAmountWithCurrCoinDenominatior = -1;
                if(curr_amount - coins[curr_money_denom_ind-1] >= 0)
                    optimalNumForPreviousAmountWithCurrCoinDenominatior = dpTable[curr_money_denom_ind] [curr_amount - coins[curr_money_denom_ind-1]];

                if(previousOptimalNumOfCoinForCurrAmount != -1){
                    if(curr_amount - coins[curr_money_denom_ind-1] >= 0 && dpTable[curr_money_denom_ind][ curr_amount - coins[curr_money_denom_ind-1]] != -1)
                        dpTable[curr_money_denom_ind][curr_amount] = Math.min(previousOptimalNumOfCoinForCurrAmount, optimalNumForPreviousAmountWithCurrCoinDenominatior + 1);
                    else
                        dpTable[curr_money_denom_ind][curr_amount] = previousOptimalNumOfCoinForCurrAmount;
                }else{
                    if(curr_amount - coins[curr_money_denom_ind-1] >= 0 && optimalNumForPreviousAmountWithCurrCoinDenominatior != -1)
                        dpTable[curr_money_denom_ind][curr_amount] = optimalNumForPreviousAmountWithCurrCoinDenominatior + 1;
                    else
                        dpTable[curr_money_denom_ind][curr_amount] = -1;
                }
            }
        }

        return dpTable[numOfCoinsDenomination - 1][numOfAmount-1];
    }
}
