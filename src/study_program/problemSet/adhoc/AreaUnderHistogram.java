package study_program.problemSet.adhoc;

import java.util.ArrayList;
import java.util.Arrays;

public class AreaUnderHistogram {
    public static void main(String[] args) {
        ArrayList<Long> heights = new ArrayList<>(Arrays.asList(2L,4L, 6L, 5L, 8L));
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>(Arrays.asList());
        queries.add(new ArrayList<>(Arrays.asList(0, 4)));
        queries.add(new ArrayList<>(Arrays.asList(3, 3)));

//        ArrayList<Long> heights = new ArrayList<>(Arrays.asList(6L, 2L, 5L, 4L, 5L, 1L, 6L));
//        ArrayList<ArrayList<Integer>> queries = new ArrayList<>(Arrays.asList());
//        queries.add(new ArrayList<>(Arrays.asList(0, 6)));


        ArrayList<Long> areas = find_largest_rectangular_areas(heights, queries);
        int a = 5;
    }

    static ArrayList<Long> find_largest_rectangular_areas(ArrayList<Long> heights, ArrayList<ArrayList<Integer>> queries) {

        long[][] total_areas_by_intervals = new long[heights.size()][heights.size()];

        int total_height = heights.size();
        for(int i = 0; i < total_height; i++){

            long the_min = heights.get(i);
            for(int j = i; j < total_height; j++){
                int start = i;
                int end = j;

                int interval_length = j - i + 1;

                long curr_height = heights.get(j);

                if(the_min > curr_height){
                    the_min = curr_height;
                }

                total_areas_by_intervals[i][j] = the_min * interval_length;
            }
        }

        ArrayList<Long> result = new ArrayList<>();

        for(int i = 0; i < queries.size(); i++){
            int query_start = queries.get(i).get(0);
            int query_end = queries.get(i).get(1);

            result.add(find_in_total_area(query_start, query_end, total_areas_by_intervals));
        }

        return result;
    }

    static long find_in_total_area(int query_start, int query_end, long[][] total_areas_by_intervals){
        // start index'ten baslayip ara

        long max_val = 0;
        int curr_row = query_start;

        while(curr_row <= query_end){
            int curr_col = curr_row;
            while(curr_col <= query_end){
                long curr_val = total_areas_by_intervals[curr_row][curr_col];
                if(max_val < curr_val){
                    max_val = curr_val;
                }
                curr_col++;
            }
            curr_row++;
        }
        return max_val;
    }
}
