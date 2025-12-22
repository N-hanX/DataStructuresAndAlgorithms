package sorting.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class meetingRooms {

    public static void main(String[] args) {
//        int[][] arr ={{1,2}, {3,4}};

//        int [][] arr = {{0,30}, {5,10}, {15,20}   }; // false


//        int [][] arr = {{7,10}, {2,4} ,{3,5}  };// false

//        int [][] arr = {{7,10}, {2,4} };// true


        int [][] arr = {{0,1 },{7,10}, {2,4}, {15,20} }; // true

        System.out.println(meetingRoom(arr));
    }

    public static boolean meetingRoom(int[][] arr){
        Map<Integer, Integer> meetingHash = new HashMap<>();
        int[] meetingStartTime = new int[(arr.length)];

        for(int i = 0; i < arr.length; i++){
            if(meetingHash.containsKey(arr[i][0])){
                return false;
            }

            meetingHash.put(arr[i][0], arr[i][1]);
            meetingStartTime[i] = arr[i][0];
        }

        Arrays.sort(meetingStartTime);

        for(int i = 0; i < meetingStartTime.length - 1; i++){
            if(meetingHash.get(meetingStartTime[i]) > meetingStartTime[i+1] ){
                return false;
            }
        }

        return true;
    }
}
