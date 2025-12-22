package study_lc.study4_c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingTimesII_253 {
    public static void main(String[] args) {
//        int[][] meetings = new int[][]{{0, 30}, {5,10}, {15,20}};

        int[][] meetings = new int[][]{{7, 10}, {2, 4}};

        int result = getNumberOfConferenceRooms(meetings);

        int a = 4;
    }

    static class Meeting implements Comparable{
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object meeting){
            Meeting other = (Meeting)meeting;
            if(this.start <= other.start)
                return -1;
            return 1;
        }
    }

    public static int getNumberOfConferenceRooms(int[][] meetings){
        List<Meeting> allMeetings = new ArrayList<>();

        for(int i = 0; i < meetings.length; i++){
            int curr_start = meetings[i][0];
            int curr_end = meetings[i][1];

            allMeetings.add(new Meeting(curr_start, curr_end));
        }

        Collections.sort(allMeetings);
        int result = 1;

        Meeting prev_meeting = allMeetings.get(0);

        for(int i = 1; i < allMeetings.size(); i++){
            Meeting curr_meeting = allMeetings.get(i);
            if(prev_meeting.start < curr_meeting.start && prev_meeting.end < curr_meeting.end){
                prev_meeting = curr_meeting;
                continue;
            }

            if(prev_meeting.start <= curr_meeting.start && prev_meeting.end >= curr_meeting.start){
                result++;
                prev_meeting = curr_meeting;
            }
        }
        return result;
    }
}
