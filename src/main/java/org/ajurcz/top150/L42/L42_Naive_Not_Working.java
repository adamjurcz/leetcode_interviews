package org.ajurcz.top150.L42;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

public class L42_Naive_Not_Working {
    static int trap(int[] height) {
        var waterHeights = new ArrayList<Integer>();
        var currentIndex = 0;

        while (currentIndex < height.length) {
            var nextWallIndex = indexOfNextWall(height, currentIndex);
            if (nextWallIndex.isPresent()) {
                var calculateSum = sumForSpan(height, currentIndex, nextWallIndex.get());
                waterHeights.add(calculateSum);
                currentIndex = nextWallIndex.get();
            } else {
                currentIndex++;
            }

        }

        return waterHeights.stream().mapToInt(Integer::intValue).sum();
    }

    static int sumForSpan(int[] height, Integer currentIndex, Integer nextWall) {
        var minHeight = Math.min(height[currentIndex], height[nextWall]);
        return IntStream.range(currentIndex + 1, nextWall)
                .boxed()
                .map(index -> minHeight - height[index])
                .mapToInt(Integer::intValue)
                .sum();
    }

    static Optional<Integer> indexOfNextWall(int[] height, int currentIndex) {
        if (currentIndex == height.length - 1) {
            return Optional.empty();
        }

        for (int i = currentIndex + 1; i < height.length; i++) {
            if (height[i] >= height[currentIndex]) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    static void main() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
