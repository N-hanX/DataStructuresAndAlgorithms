package sort2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoom {
    public static void main(String[] args) {
        int[][] meetings = new int[][]{{0,30}, {5, 10}, {15, 20}};

        List<Meeting> meetingList = new ArrayList<>();

        MeetingRoom m = new MeetingRoom();

        for(int i = 0; i < meetings.length; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            Meeting meeting = new Meeting(start, end);
            meetingList.add(meeting);
        }

        Collections.sort(meetingList);
        int prev_end = -1;
        boolean meetingPossible = true;
        for(int i = 0; i < meetingList.size(); i++){
            int start = meetingList.get(i).start;
            int end = meetingList.get(i).end;

            if(prev_end > start){
                meetingPossible = false;
                break;
            }
            prev_end = end;
        }
        int a = 5;

    }

    public static class Meeting implements Comparable {
        public int start;
        public int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Meeting m = (Meeting)o;
            if(this.start < m.start){
                return -1;
            }else if(this.start > m.start){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
