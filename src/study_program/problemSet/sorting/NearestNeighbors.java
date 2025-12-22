package study_program.problemSet.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NearestNeighbors {
    static class PointInfo implements Comparable<PointInfo>{
        Integer x;
        Integer y;
        Double euclid_dist;

        public PointInfo(Integer x, Integer y, Double euclid_dist){
            this.x = x;
            this.y = y;
            this.euclid_dist = euclid_dist;
        }

        @Override
        public int compareTo(PointInfo o) {
            if(o.euclid_dist > this.euclid_dist)
                return 1;
            return -1;
        }
    }

    static ArrayList<ArrayList<Integer>> nearest_neighbours(Integer p_x, Integer p_y, Integer k,
                                                            ArrayList<ArrayList<Integer>> n_points) {
        PriorityQueue<PointInfo> distances = new PriorityQueue<>();

        for(int i = 0; i < n_points.size(); i++){
            ArrayList<Integer> curr_point = n_points.get(i);
            int curr_x = curr_point.get(0);
            int curr_y = curr_point.get(1);

            double diff = Math.sqrt(Math.pow(curr_x - p_x, 2) + Math.pow(curr_y - p_y, 2));

            PointInfo the_point = new PointInfo(curr_x, curr_y, diff);

            distances.add(the_point);
            if(distances.size() == k + 1){
                distances.poll();
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < k; i++){
            PointInfo point = distances.peek();
            result.add(new ArrayList<>(Arrays.asList(point.x, point.y)));
            distances.poll();
        }

        return result;
    }

    public static void main(String[] args) {
//{
//"p_x": 1,
//"p_y": 1,
//"k": 1,
//"n_points": [
//[0, 0],
//[1, 0]
//]
//        }

        int p_x = 1;
        int p_y = 1;
        int k = 1;
        ArrayList<ArrayList<Integer>> n_points = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 0));
        n_points.add(arr1);
        n_points.add(arr2);

        ArrayList<ArrayList<Integer>> result = nearest_neighbours(p_x, p_y, k, n_points );
        int a = 4;
    }
}
