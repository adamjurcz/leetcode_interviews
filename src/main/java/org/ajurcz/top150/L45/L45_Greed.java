package org.ajurcz.top150.L45;

public class L45_Greed {
    static int jump(int[] nums) {
        int currentIndex = 0;
        int bestChoiceIndex;
        int result = 0;

        while(currentIndex < nums.length - 1) {
            bestChoiceIndex = currentIndex + 1;

            if(canFinish(nums, currentIndex)) {
                return result + 1;
            }

            for(int i = 2; i <= nums[currentIndex] && currentIndex + i < nums.length; i++) {
                int nextToCheck = currentIndex + i;
                if(isBetterForNextJump(nums, nextToCheck, bestChoiceIndex)) {
                    bestChoiceIndex = nextToCheck;
                }
            }
            currentIndex = bestChoiceIndex;
            result++;
        }
        return result;
    }

    static boolean isBetterForNextJump(int[] nums, int index, int bestChoiceIndex) {
        return nums[index] + index >= nums[bestChoiceIndex] + bestChoiceIndex;
    }

    static boolean canFinish(int[] nums, int index) {
        return index + nums[index] >= nums.length - 1;
    }
    
    static void main() {
        System.out.println(jump(new int[]{3,2,1}));
    }
}
