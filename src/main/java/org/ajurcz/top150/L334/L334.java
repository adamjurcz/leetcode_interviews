package org.ajurcz.top150.L334;

public class L334 {

    static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];

            if (element <= first) {
                first = element;
            } else if (element <= second) {
                second = element;
            } else {
                System.out.printf("First : %s ; Second : %s ; Third : %s\n", first, second, element);
                return true;
            }
        }
        return false;
    }

    static void main() {
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 13, 6}));
    }
    // [2 [first=2, second = MAX], ...]
    // [2, 1 [first=1, second = MAX], ...]
    // [2, 1, 5 [first = 1, second = 5], ...]
    // [2, 1, 5, 0 [first = 0, second = 5], ...]
}
