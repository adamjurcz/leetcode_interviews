package org.ajurcz.top150.L6;

import java.util.*;
import java.util.stream.Collectors;

public class L6 {
    //ZIG-ZAG conversion
    /*
    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:
    P     I    N
    A   L S  I G
    Y A   H R
    P     I


     */
    static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        Map<Integer, List<Character>> rowNumToCharacters = new TreeMap<>();
        int gapBetweenColumns = numRows - 2;
        int currentRow = 0;

        for(int i = 0; i < s.length(); i++) {
            int localIndex = i % (numRows + gapBetweenColumns);
            rowNumToCharacters.computeIfAbsent(currentRow, _ -> new ArrayList<>()).add(s.charAt(i));

            if(localIndex < numRows - 1) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        return rowNumToCharacters.values().stream().map(L6::listOfCharsToString).collect(Collectors.joining());
    }

    static String listOfCharsToString(List<Character> characters) {
        return characters.stream().map(String::valueOf).collect(Collectors.joining());
    }

    static void main() {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
