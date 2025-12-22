package study4_x;

import java.util.*;

public class NumberOfBlackBlocks_2768 {
    public static long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Set<String> blackSet = new HashSet<String>();
        Map<String, Integer> blockCount = new HashMap<String, Integer>();

        for (int[] cell : coordinates) {
            int x = cell[0];
            int y = cell[1];
            blackSet.add(x + "," + y);
        }

        // Directions: top-left of each affected 2x2 block
        int[][] dirs = {{-1, -1}, {-1, 0}, {0, -1}, {0, 0}};

        for (int[] cell : coordinates) {
            int x = cell[0];
            int y = cell[1];

            for (int[] d : dirs) {
                int i = x + d[0];
                int j = y + d[1];
                if (i >= 0 && j >= 0 && i < m - 1 && j < n - 1) {
                    String key = i + "," + j;
                    blockCount.put(key, blockCount.getOrDefault(key, 0) + 1);
                }
            }
        }

        long[] result = new long[5]; // result[0..4]
        for (int count : blockCount.values()) {
            result[count]++;
        }

        long totalBlocks = (long)(m - 1) * (n - 1);
        result[0] = totalBlocks;
        for (int i = 1; i <= 4; i++) {
            result[0] -= result[i];
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] coordinates = {{0, 0}, {1, 1}, {0, 1}};
        long[] res = countBlackBlocks(m, n, coordinates);
        System.out.println(Arrays.toString(res)); // Example output
    }

}
