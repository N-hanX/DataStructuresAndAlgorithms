package study_lc.study4_c;

public class GasStation_134 {
    public static void main(String[] args) {
//[1,2,3,4,5]gas
//        cost [3,4,5,1,2]
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int result = canCompleteCircuit(gas, cost);
        int a  =4;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalLen = gas.length;
        int starterInd = 0;
        int nextStationInd = 1;
        int currCost;
        int tempInd = 0;

        int equality_counter = 0;
        int impossible_counter = 0;


        for(int i = 0; i < gas.length; i++){
            if(gas[i] == cost[i]){
                equality_counter++;
            }

            if(gas[i] < cost[i]){
                equality_counter++;
                impossible_counter++;
            }
        }

        if(equality_counter == gas.length && impossible_counter > 0){
            return -1;
        }


        if( totalLen == 1 && gas[starterInd] > cost[starterInd]){
            return 0;
        }

        while(starterInd < totalLen){
            if(starterInd == totalLen - 1){
                nextStationInd = 0;
            }

            currCost = gas[starterInd];
            // System.out.println("start ind: " + starterInd + " currCost: " + currCost);

            if(currCost == 0 || currCost < cost[starterInd]){ // first step
                starterInd++;
                nextStationInd++;
                tempInd++;
                continue;
            }

            boolean done = false;

            while(true){
                if(nextStationInd == totalLen){
                    nextStationInd = 0;
                }
                if(tempInd == totalLen){
                    tempInd = 0;
                }

                int nextCost = currCost - cost[tempInd] + gas[nextStationInd];
                // System.out.println("travel to station: " + nextStationInd + " my tank will be: " + nextCost);

                if(currCost >= cost[tempInd]){
                    currCost = nextCost;
                }else{
                    break;
                }
                tempInd++;
                nextStationInd++;
                // next temp gas

                if(nextStationInd == totalLen){
                    nextStationInd = 0;
                }

                if(tempInd == totalLen){
                    tempInd = 0;
                }

                if(tempInd == starterInd){
                    return starterInd;
                }
            }
            starterInd++;
            nextStationInd = starterInd + 1;
            tempInd = starterInd;
        }

        return -1;
    }
}
