package org.ajurcz.top150.L167;

import java.util.Arrays;

public class L167 {
    static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum > target) {
                j--;
            }
            if (sum < target) {
                i++;
            }
        }
        return null;
    }

    static void main() {
        System.out.println(Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).asLongStream().boxed().toList());
    }
}
