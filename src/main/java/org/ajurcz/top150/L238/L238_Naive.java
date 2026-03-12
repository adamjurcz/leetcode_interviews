package org.ajurcz.top150.L238;

import java.util.Arrays;
import java.util.stream.IntStream;


/*
O(n^2)
 */
public class L238_Naive {
    static int[] productExceptSelf(int[] nums) {
        int[] product = nums.clone();

        if (nums.length == 1) {
            return nums;
        }

        IntStream.range(0, nums.length).forEach(indexToExclude -> {
            int firstIndexOfProduct = getFirstIndexOfProduct(indexToExclude);
            int result = nums[firstIndexOfProduct];

            for (int index = 0; index < nums.length; index++) {
                if (index != indexToExclude && index != firstIndexOfProduct) {
                    result = result * nums[index];
                }
            }
            product[indexToExclude] = result;
        });

        return product;
    }

    static int getFirstIndexOfProduct(int indexToExclude) {
        if (indexToExclude == 0) {
            return 1;
        }
        return 0;
    }

    static void main() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
