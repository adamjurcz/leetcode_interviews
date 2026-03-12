package org.ajurcz.top150.L55;

public class L55_Greed {
    static boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        int indexToReach = nums.length - 1;
        int indexCurrent = nums.length - 2;

        while(indexCurrent >= 0) {
            if(canReachIndex(indexCurrent, indexToReach, nums)) {
                indexToReach = indexCurrent;
                indexCurrent--;
            } else {
                indexCurrent--;
            }
        }
        return indexToReach == 0;
    }

    static boolean canReachIndex(int indexCurrent, int indexToReach, int[] nums) {
        return indexCurrent + nums[indexCurrent] >= indexToReach;
    }

    static void main() {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
