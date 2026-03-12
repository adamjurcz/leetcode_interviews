package org.ajurcz.top150.L42;

import java.util.ArrayList;
import java.util.List;

public class L42_Optimised {
    static int trap(int[] height) {
        List<Integer> resultHeight = new ArrayList<>();

        int[] right = getRight(height);
        int[] left = getLeft(height);

        for (int i = 0; i < height.length; i++) {
            int minOfMaxNeighbours = Math.min(left[i], right[i]);
            int pointHeight = minOfMaxNeighbours - height[i];
            if (pointHeight > 0) {
                resultHeight.add(pointHeight);
            }
        }

        return resultHeight.stream().mapToInt(Integer::intValue).sum();
    }

    static int[] getRight(int[] height) {
        int[] result = new int[height.length];
        int previousMax = 0;
        result[height.length - 1] = previousMax;

        for (int i = result.length - 2; i >= 0; i--) {
            if (height[i + 1] > previousMax) {
                previousMax = height[i + 1];
            }
            result[i] = previousMax;
        }

        return result;
    }

    static int[] getLeft(int[] height) {
        int[] result = new int[height.length];
        int previousMax = 0;
        result[0] = previousMax;

        for (int i = 1; i < result.length; i++) {
            if (height[i - 1] > previousMax) {
                previousMax = height[i - 1];
            }
            result[i] = previousMax;
        }

        return result;
    }

    static void main() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
