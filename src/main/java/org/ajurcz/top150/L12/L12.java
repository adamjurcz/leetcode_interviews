package org.ajurcz.top150.L12;

import java.util.Map;
import java.util.TreeMap;

public class L12 {
    private static final TreeMap<Integer, String> intToRoman = new TreeMap<>(Map.ofEntries(
            Map.entry(1000, "M"),
            Map.entry(900, "CM"),
            Map.entry(500, "D"),
            Map.entry(400, "CD"),
            Map.entry(100, "C"),
            Map.entry(90, "XC"),
            Map.entry(50, "L"),
            Map.entry(40, "XL"),
            Map.entry(10, "X"),
            Map.entry(9, "IX"),
            Map.entry(5, "V"),
            Map.entry(4, "IV"),
            Map.entry(1, "I")));

    static String intToRoman(int num) {
        String result = "";

        for (var entry : intToRoman.descendingMap().entrySet()) {
            int divisor = entry.getKey();

            int count = num / divisor;
            if (count > 0) {
                result = result.concat(entry.getValue().repeat(count));
                num = num % divisor;
            }
        }
        return result;
    }


    static void main() {
        System.out.println(intToRoman(2619));
    }
}
