package study_program.lectureNotes.stack;

public class BestTime2BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int the_result = maxProfit(prices);
        int a = 4;
    }

    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        int the_end_ind = prices.length;

        while(rightPointer < the_end_ind && leftPointer < the_end_ind){
            int buyPrice = prices[leftPointer];
            int sellPrice = prices[rightPointer];

            int curr_profit = sellPrice - buyPrice;

            if(curr_profit >= max_profit){
                max_profit = curr_profit;
                rightPointer++;
            }else if(buyPrice > sellPrice){
                leftPointer = rightPointer;
                rightPointer++;
            }else{
                rightPointer++;
            }
        }

        return max_profit;
    }

    static class ProfitInfo implements Comparable<ProfitInfo>{
        int price;
        int index;

        public ProfitInfo(int price, int index){
            this.price = price;
            this.index = index;
        }

        @Override
        public int compareTo(ProfitInfo p){
            return Integer.compare(this.price, p.price);
        }
    }
}
