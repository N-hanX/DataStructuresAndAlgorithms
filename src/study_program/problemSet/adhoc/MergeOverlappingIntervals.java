package study_program.problemSet.adhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
//            [100, 154],
//            [13, 47],
//            [1, 5],
//            [2, 9],
//            [7, 11],
//            [51, 51],
//            [47, 50]
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(100, 154));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(13, 47));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(1, 5));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2, 9));
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(7, 11));
        ArrayList<Integer> arr6 = new ArrayList<>(Arrays.asList(51, 51));
        ArrayList<Integer> arr7 = new ArrayList<>(Arrays.asList(47, 50));

        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        intervals.add(arr1);
        intervals.add(arr2);
        intervals.add(arr3);
        intervals.add(arr4);
        intervals.add(arr5);
        intervals.add(arr6);
        intervals.add(arr7);


//        {
//            "intervals": [
//[10, 12],
//[1, 2],
//[1000, 100000],
//[-1000000000, 1000000000],
//[2, 5],
//[7, 10],
//[123, 456]
//]
//        }

        ArrayList<ArrayList<Integer>> result = get_merged_intervals(intervals);

        int a = 5;
    }

    static ArrayList<ArrayList<Integer>> get_merged_intervals(ArrayList<ArrayList<Integer>> intervals) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Interval> interval_result = new ArrayList<>();

        ArrayList<Interval> interval_list = new ArrayList<>();

        for(int i = 0; i < intervals.size(); i++){
            Interval interval = new Interval(intervals.get(i).get(0), intervals.get(i).get(1));

            interval_list.add(interval);
        }

        Collections.sort(interval_list);
        interval_result.add(interval_list.get(0));

        int index_counter = 1;

        while(index_counter < interval_list.size()){
            Interval last_element_in_result = interval_result.get(interval_result.size() - 1);
            Interval curr_element = interval_list.get(index_counter);

            if(last_element_in_result.end >= curr_element.start && last_element_in_result.end >= curr_element.end){

            }else if(last_element_in_result.end >= curr_element.start){
                last_element_in_result.setStart(last_element_in_result.start);
                last_element_in_result.setEnd(curr_element.end);
//                interval_result.set(index_counter - 1, last_element_in_result);
            }else{
                interval_result.add(curr_element);
            }

            index_counter++;
        }

        for(int i = 0; i < interval_result.size(); i++){
            ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(interval_result.get(i).getStart(),
                    interval_result.get(i).getEnd()));
            result.add(arr);
        }

        return result;
    }

    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if(this.start <= o.start){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
