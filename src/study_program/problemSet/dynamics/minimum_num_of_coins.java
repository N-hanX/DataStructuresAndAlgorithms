package study_program.problemSet.dynamics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class minimum_num_of_coins {
    public static void main(String[] args) {
//        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(1,3,5));
//        int n = 9;
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(22, 14, 1, 18));
        int n = 889;

        Integer result = minimum_coins(coinList, n);

        int a = 5;
    }

    static Integer minimum_coins(ArrayList<Integer> coins, Integer value) {
        if(value == 0){
            return 1;
        }

        Collections.sort(coins);

        ArrayList<ArrayList<Integer>> min_coin_table = new ArrayList<>();

        // row refers to the total money
        // col refers to the considered coins

        for(int rowInd = 0; rowInd <= coins.size(); rowInd++){
            ArrayList<Integer> row = new ArrayList<>();
            int count = 0;
            while(count <= value){
                row.add(null);
                count++;
            }
            min_coin_table.add(row);

            for(int colInd = 0; colInd <= value; colInd++){
                if(rowInd == 0 && colInd == 0){
                    min_coin_table.get(rowInd).set(colInd, 1);
                    continue;
                }
                if(rowInd == 0){
                    min_coin_table.get(rowInd).set(colInd, null);
                    continue;
                }
                if(colInd == 0){
                    min_coin_table.get(rowInd).set(colInd, 0);
                    continue;
                }


                int minimum_num_of_coin = Integer.MAX_VALUE;

                if(rowInd > 1){
                    minimum_num_of_coin = min_coin_table.get(rowInd - 1).get(colInd);
                }

                // sadece o an hesaba kattigin para miktarlariyla hesapla
                for(int coinInd = 0; coinInd < rowInd; coinInd++){
                    int curr_coin = coins.get(coinInd);

                    Integer curr_min_num_of_coin = null;
                    if(colInd - curr_coin < 0){
                        continue;
                    }
                    if(colInd - curr_coin >= 0)
                        curr_min_num_of_coin = min_coin_table.get(rowInd).get(colInd - curr_coin);

                    if(curr_min_num_of_coin != null)
                        minimum_num_of_coin = Math.min(minimum_num_of_coin, curr_min_num_of_coin + 1);
                    int a= 5;
                }
                min_coin_table.get(rowInd).set(colInd, minimum_num_of_coin);
            }
        }

        return min_coin_table.get(coins.size()).get(value);
    }
}
