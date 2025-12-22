package study_program.problemSet.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        //        {
//            "pixel_row": 0,
//                "pixel_column": 1,
//                "new_color": 2,
//                "image": [
//                [0, 1, 3],
//                [1, 1, 1],
//                [1, 5, 4]
//                ]
//        }

//        int pixel_row = 1;
//        int pixel_column = 0;
//        int new_color = 9;
//
//        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(0, 2, 1));
//        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 1, 2));
//        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(2, 5, 4));
//        ArrayList<ArrayList<Integer>> fullList = new ArrayList<>();
//        fullList.add(list1);
//        fullList.add(list2);
//        fullList.add(list3);
//        flood_fill(pixel_row, pixel_column, new_color, fullList);


        int pixel_row = 0;
        int pixel_column = 4;
        int new_color = 7;

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(7,7,7,7,7,7));
        ArrayList<ArrayList<Integer>> fullList = new ArrayList<>();
        fullList.add(list1);

        flood_fill(pixel_row, pixel_column, new_color, fullList);
        int a = 5;
    }


    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, ArrayList<ArrayList<Integer>> image) {
        flood_the_related_fill(image.get(pixel_row).get(pixel_column), pixel_row, pixel_column, new_color, image);
        return image;
    }

    static void flood_the_related_fill(int originalPixelValue, int rowInd, int colInd, int newPixelValue,
                                       ArrayList<ArrayList<Integer>> image){
        if(originalPixelValue == newPixelValue){
            return;
        }

        if(rowInd < 0 || colInd < 0 || rowInd >= image.size() || colInd >= image.get(0).size()){
            return;
        }

        if(image.get(rowInd).get(colInd) == originalPixelValue){
            image.get(rowInd).set(colInd, newPixelValue);
        }else{
            return;
        }

        flood_the_related_fill(originalPixelValue, rowInd + 1, colInd, newPixelValue, image);
        flood_the_related_fill(originalPixelValue, rowInd - 1, colInd, newPixelValue, image);
        flood_the_related_fill(originalPixelValue, rowInd, colInd + 1, newPixelValue, image);
        flood_the_related_fill(originalPixelValue, rowInd, colInd - 1, newPixelValue, image);
    }

}
