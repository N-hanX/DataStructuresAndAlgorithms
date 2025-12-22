package study_lc;

import java.util.HashMap;
import java.util.Map;

public class PrisonAfterNDays {
    public static void main(String[] args) {
//        int[] cells = new int[]{0,1,0,1,1,0,0,1};
//        int n = 7;
//        int[] cells = new int[]{1,0,0,1,0,0,1,0};
//        int n = 1000000000;

//        int[] cells = new int[]{1,1,0,1,1,0,1,1};
//        int n = 6;
//
        int[] cells = new int[]{1,1,0,1,1,0,0,1};
        int n = 300663720;

//        int[] cells = new int[]{0,0,0,1,1,0,1,0};
//        int n = 574;

        int[] result = prisonAfterNDays(cells, n);

        int a = 4;
    }

    public static int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> prisonByDay = new HashMap<>();
        Map<Integer, String> dayByPrison = new HashMap<>();

        int counter = 0;
        String thePrison = null;
        boolean getMod = false;

        while(counter < n){
            StringBuilder total = new StringBuilder();
            for(int i = 0; i < cells.length; i++){
                total.append(String.valueOf(cells[i]));
            }
            thePrison = total.toString();

            if(!prisonByDay.containsKey(thePrison)){
                prisonByDay.put(thePrison, counter);
                dayByPrison.put(counter, thePrison);
            }else{
                getMod = true;
                break;
            }

            calculateNextDay(cells);
            counter++;
        }

        if(getMod) {
            // calculate remaining
            int theFirstPatternDay = prisonByDay.get(thePrison);
            int patternLength = counter - theFirstPatternDay;

            int theMod = (n - theFirstPatternDay) % patternLength;

            theMod = theMod + theFirstPatternDay;

            String result = dayByPrison.get(theMod);

            int[] resultCell = new int[8];

            for (int i = 0; i < 8; i++) {
                resultCell[i] = result.charAt(i) - '0';
            }
            return resultCell;
        }else{
            return cells;
        }
    }

    public static void calculateNextDay(int[] cells){
        int[] prevCells = new int[cells.length];

        for(int i = 0; i < cells.length; i++){
            prevCells[i] = cells[i];
        }

        for(int i = 0; i < 8; i++){
            if(i == 0 || i == 7){
                cells[i] = 0;
            }else{
                boolean booleanResult = getXORResult(prevCells[i - 1], prevCells[ i + 1]);
                if(booleanResult)
                    cells[i] = 1;
                else
                    cells[i] =0;
            }
        }
    }

    public static boolean getXORResult(int val1, int val2){
        if(val1 == val2)
            return true;
        else
            return false;
    }
}
