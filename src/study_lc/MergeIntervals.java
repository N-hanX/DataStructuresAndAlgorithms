package study_lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        int[][] result = merge(intervals);
        int a = 4;
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }

        PriorityQueue<Interval> intervals_queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < intervals.length; i++){
            intervals_queue.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        ArrayList<Interval> result = new ArrayList<>();
        Interval prevInterval = intervals_queue.poll();

        while(!intervals_queue.isEmpty()){
            Interval currInterval = intervals_queue.poll();

            if(currInterval.start <= prevInterval.end){
                if(currInterval.end <= prevInterval.end){
                    prevInterval = new Interval(prevInterval.start, prevInterval.end);
                }else{
                    prevInterval = new Interval(prevInterval.start, currInterval.end);
                }


                if(intervals_queue.size() == 0){
                    result.add(prevInterval);
                }
            }else{
                result.add(prevInterval);
                prevInterval = currInterval;

                if(intervals_queue.size() == 0){
                    result.add(currInterval);
                }
            }
        }

        int[][] resultArr = new int[result.size()][2];

        for(int i = 0; i < result.size(); i++){
            resultArr[i][0] = result.get(i).start;
            resultArr[i][1] = result.get(i).end;
        }
        return resultArr;
    }

    static class Interval implements Comparable{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Interval otherObj = (Interval)o;

            if(this.start <= otherObj.start){
                return 1;
            }
            return -1;
        }
    }
}
