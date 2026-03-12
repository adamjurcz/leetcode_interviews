package org.ajurcz.top150.L238;

import java.util.Arrays;
import java.util.stream.IntStream;

public class L238_Optimised {

    static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            if (index == 0) {
                left[index] = 1;
            } else {
                left[index] = left[index - 1] * nums[index - 1];
            }
        }
        for (int index = nums.length - 1; index >= 0; index--) {
            if (index == nums.length - 1) {
                right[index] = 1;
            } else {
                right[index] = right[index + 1] * nums[index + 1];
            }
        }

        IntStream.range(0, nums.length).forEach(index -> {
            nums[index] = left[index] * right[index];
        });
        return nums;
    }

    static void main() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
