package org.ajurcz.top150.L54;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class L54 {
    static List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] wasVisited = new boolean[matrix.length][matrix[0].length];

        int num = 0;
        int row = 0;
        int col = 0;
        Direction direction = Direction.ROW;
        List<Integer> result = new ArrayList<>();

        while (num < (matrix.length * matrix[0].length)) {
            result.add(matrix[row][col]);
            wasVisited[row][col] = true;

            var next = nextMove(matrix, wasVisited, direction, row, col);
            if (Objects.isNull(next)) {
                break;
            }

            row = next.get(0);
            col = next.get(1);
            if (next.get(2) == 1) {
                direction = Direction.COLUMN;
            } else {
                direction = Direction.ROW;
            }

            num++;
        }
        return result;
    }

    private static List<Integer> nextMove(int[][] matrix, boolean[][] wasVisited, Direction direction,
                                          int currentRow, int currentColumn) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        if (direction == Direction.ROW) {
            if (currentColumn + 1 < colLength && !wasVisited[currentRow][currentColumn + 1]) {
                return List.of(currentRow, currentColumn + 1, 0);
            } else if (currentColumn - 1 >= 0 && !wasVisited[currentRow][currentColumn - 1]) {
                return List.of(currentRow, currentColumn - 1, 0);
            } else if (currentRow + 1 < rowLength && !wasVisited[currentRow + 1][currentColumn]) {
                return List.of(currentRow + 1, currentColumn, 1);
            } else if (currentRow - 1 >= 0 && !wasVisited[currentRow - 1][currentColumn]) {
                return List.of(currentRow - 1, currentColumn, 1);
            } else {
                return null;
            }
        } else {
            if (currentRow + 1 < rowLength && !wasVisited[currentRow + 1][currentColumn]) {
                return List.of(currentRow + 1, currentColumn, 1);
            } else if (currentRow - 1 >= 0 && !wasVisited[currentRow - 1][currentColumn]) {
                return List.of(currentRow - 1, currentColumn, 1);
            } else if (currentColumn + 1 < colLength && !wasVisited[currentRow][currentColumn + 1]) {
                return List.of(currentRow, currentColumn + 1, 0);
            } else if (currentColumn - 1 >= 0 && !wasVisited[currentRow][currentColumn - 1]) {
                return List.of(currentRow, currentColumn - 1, 0);
            } else {
                return null;
            }
        }
    }

    static void main() {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    enum Direction {
        ROW,
        COLUMN
    }
}
