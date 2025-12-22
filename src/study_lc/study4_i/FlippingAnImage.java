package study_lc.study4_i;

public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] img = new int[][]{{1,1,0},{1,0,1},{0,0,0}};

        int[][] result = flipAndInvertImage(img);

        int a = 4;
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int numOfRow = image.length;
        int numOfCol = image[0].length;

        for(int i = 0; i < numOfRow; i++){
            int startInd = 0;
            int endInd = numOfCol - 1;

            while(startInd <= endInd){
                int leftInd = image[i][startInd];
                int rightInd = image[i][endInd];

                image[i][startInd] = inverse(rightInd);
                image[i][endInd] = inverse(leftInd);
                startInd++;
                endInd--;
            }
        }

        return image;
    }

    public static int inverse(int i){
        if(i == 1)
            return 0;
        return 1;
    }
}
