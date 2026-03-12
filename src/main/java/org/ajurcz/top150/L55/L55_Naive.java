package org.ajurcz.top150.L55;

import java.util.LinkedList;
import java.util.Queue;

public class L55_Naive {
    static boolean canJump(int[] nums) {
        Integer currentIndex = 0;
        Queue<Integer> nextJumpIndex = new LinkedList<>();
        if(nums.length == 1) {
            return true;
        }

        nextJumpIndex.offer(currentIndex);
        while(!nextJumpIndex.isEmpty()) {
            currentIndex = nextJumpIndex.poll();
            for(int i = 1; i <= nums[currentIndex]; i++) {
                var nextIndex = currentIndex + i;

                if(nextIndex == nums.length - 1) {
                    return true;
                }
                if(!nextJumpIndex.contains(nextIndex) && nextIndex < nums.length) {
                    nextJumpIndex.offer(nextIndex);
                }
            }
        }
        return false;
    }

    static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,2,0,1,5}));
    }
}
