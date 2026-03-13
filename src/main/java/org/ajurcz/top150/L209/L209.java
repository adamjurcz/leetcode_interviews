package org.ajurcz.top150.L209;

public class L209 {
    static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minWindowsSpan = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minWindowsSpan = Math.min(minWindowsSpan, right + 1 - left);
                currentSum -= nums[left];
                left++;
            }
        }

        return minWindowsSpan == Integer.MAX_VALUE ? 0 : minWindowsSpan;
    }

    static void main() {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
