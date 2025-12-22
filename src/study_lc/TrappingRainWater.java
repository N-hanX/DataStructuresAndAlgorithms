package study_lc;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,};

        int total_water = trap(height);

        int a = 4;
    }

    public static int trap(int[] height) {
        int total = 0;

        int last_index = height.length;
        int ptr1 = 0;
        int ptr2 = 1;

        while(ptr1 < last_index && ptr2 < last_index){
            if(height[ptr1] < height[ptr2]){

            }else{
                total += calculateIntervalTrap(ptr1, ptr2, height);
                ptr1 = ptr2 + 1;
                ptr2++;
            }
        }
        return total;
    }

    public static int calculateIntervalTrap(int ptr1, int ptr2, int[] height){
        int approx_total;
        if(ptr1 > 0 && height[ptr1 - 1] < height[ptr2]){
            approx_total = height[ptr2] * (ptr2 - ptr1);
        }else{
            approx_total = height[ptr1] * (ptr2 - ptr1 - 1);
        }
        return approx_total;
    }
}
