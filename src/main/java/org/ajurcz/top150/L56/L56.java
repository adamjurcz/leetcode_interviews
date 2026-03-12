package org.ajurcz.top150.L56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56 {

    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(el -> el[0]));

        List<List<Integer>> merged = new ArrayList<>();
        merged.add(new ArrayList<>(List.of(intervals[0][0], intervals[0][1])));

        for (int i = 1; i < intervals.length; i++) {
            int firstIndex = intervals[i][0];
            int secondIndex = intervals[i][1];

            int lastElementFirstIndex = merged.getLast().getFirst();
            int lastElementLastIndex = merged.getLast().getLast();

            if (firstIndex <= lastElementLastIndex) {
                //Can be merged
                List<Integer> last = merged.getLast();
                last.set(0, lastElementFirstIndex);
                last.set(1, Math.max(lastElementLastIndex, secondIndex));
            } else {
                merged.add(new ArrayList<>(List.of(firstIndex, secondIndex)));
            }
        }

        return merged.stream().map(row -> row.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }

    static void main() {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {0, 4}})));
    }
}
