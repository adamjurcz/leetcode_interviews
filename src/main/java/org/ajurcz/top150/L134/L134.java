package org.ajurcz.top150.L134;

import java.util.stream.IntStream;

public class L134 {
    private static final int INDEX_NOT_FOUND = -1;

    static int gasStation(int[] gas, int[] cost) {
        int difference = IntStream.range(0, gas.length).map(index -> gas[index] - cost[index]).sum();
        int currentFuel = 0;
        int resultIndex = 0;

        if (difference > 0) {
            return INDEX_NOT_FOUND;
        }

        for (int index = 0; index < gas.length; index++) {
            currentFuel += gas[index] - cost[index];

            if (currentFuel < 0) {
                currentFuel = 0;
                resultIndex = index + 1;
            }
        }

        return resultIndex;
    }

    static void main() {
        var gas = new int[]{1, 2, 3, 4, 5};
        var cost = new int[]{3, 4, 5, 1, 2};

        System.out.println(gasStation(gas, cost));
    }
}
