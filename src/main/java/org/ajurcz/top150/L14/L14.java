package org.ajurcz.top150.L14;

import static java.util.Arrays.stream;

public class L14 {

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        var sortedInput = stream(strs).sorted().toList();
        var firstElement = sortedInput.getFirst();
        var lastElement = sortedInput.getLast();

        for (int i = 0; i < firstElement.length(); i++) {
            if (firstElement.charAt(i) != lastElement.charAt(i)) {
                return firstElement.substring(0, i);
            }
        }
        return firstElement;
    }

    static void main() {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
