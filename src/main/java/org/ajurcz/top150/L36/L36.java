package org.ajurcz.top150.L36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L36 {
    static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> square = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;

                int squareIndex = (i / 3) * 3 + j / 3;
                int value = Character.getNumericValue(board[i][j]);

                if (!rows.computeIfAbsent(i, k -> new HashSet<>()).add(value) ||
                        !cols.computeIfAbsent(j, k -> new HashSet<>()).add(value) ||
                        !square.computeIfAbsent(squareIndex, k -> new HashSet<>()).add(value)
                ) return false;
            }
        }
        return true;
    }


    static void main() {
        System.out.println(isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
