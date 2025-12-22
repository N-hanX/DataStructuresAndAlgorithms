package study_lc.study4_c;

public class FindTheLargestAreaOfSquareInsideTwoRect_3047 {
    public static void main(String[] args) {
//bottom Left[[1,1],[2,2],[3,1]]
//        topRIght [[3,3],[4,4],[6,6]]
    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long result = 0L;
        int numOfRect = bottomLeft.length;

        for(int i = 0; i < numOfRect; i++){
            int curr_x_diff = topRight[i][0] - bottomLeft[i][0];
            int curr_y_diff = topRight[i][1] - bottomLeft[i][1];
            int min_diff = Math.min(curr_x_diff, curr_y_diff);

            if(min_diff < result){
                continue;
            }

            for(int j = i + 1; j < numOfRect; j++){
                int startCurrRectX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int endCurrRectX = Math.min(topRight[i][0], topRight[j][0]);

                int startCurrRectY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int endCurrRectY = Math.min(topRight[i][1], topRight[j][1]);

                if(startCurrRectX < endCurrRectX && startCurrRectY < endCurrRectY){
                    long x_diff = endCurrRectX - startCurrRectX;
                    long y_diff = endCurrRectY - startCurrRectY;

                    long curr_result = Math.min(x_diff, y_diff);

                    if(result < curr_result){
                        result = curr_result;
                    }
                }
            }
        }

        return (long)Math.pow(result, 2);
    }
}
