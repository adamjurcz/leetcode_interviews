package org.ajurcz.top150.L54;

import java.util.ArrayList;
import java.util.List;

public class L54_Optimised {

    static List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) { // DIRECTION: RIGHT
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) { // DIRECTION: DOWN
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) { // DIRECTION: LEFT
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) { // DIRECTION: UP
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }

        return result;
    }

    static void main() {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
