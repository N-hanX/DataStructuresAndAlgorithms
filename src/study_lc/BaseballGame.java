package study_lc;

import java.util.ArrayList;

public class BaseballGame {
    public static void main(String[] args) {
        String[] operations = new String[]{"5","2","C","D","+"};
        int result = calPoints(operations);

        int a = 4;
    }

    public static int calPoints(String[] operations) {
        ArrayList<Integer> records = new ArrayList<>();
        for(int i = 0; i < operations.length; i++){
            String currChar = operations[i];

            if(currChar.equals("C")){
                if(!records.isEmpty()){
                    records.remove(records.size() - 1);
                }
            }else if(currChar.equals("D")){
                if(!records.isEmpty()){
                    int theLastRecord = records.get(records.size() - 1);
                    records.add(theLastRecord * 2);
                }
            }else if(currChar.equals("+")){
                if(records.size() >= 2){
                    int theLastRecord = records.get(records.size() - 1);
                    int theLastRecord2 = records.get(records.size() - 2);
                    records.add(theLastRecord + theLastRecord2);
                }
            }else{
                records.add(Integer.valueOf(currChar));
            }
        }

        int total = 0;
        for(int i = 0; i < records.size(); i++){
            total += records.get(i);
        }

        return total;
    }
}