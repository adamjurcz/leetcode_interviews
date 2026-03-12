package org.ajurcz.top150.L13;

import java.util.AbstractMap;
import java.util.Map;

public class L13 {
    private static final Map<String, Integer> romanToInteger = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("I", 1),
            new AbstractMap.SimpleEntry<>("V", 5),
            new AbstractMap.SimpleEntry<>("X", 10),
            new AbstractMap.SimpleEntry<>("L", 50),
            new AbstractMap.SimpleEntry<>("C", 100),
            new AbstractMap.SimpleEntry<>("D", 50),
            new AbstractMap.SimpleEntry<>("M", 1000)
    );

    static int romanToInt(String s) {
        int sum = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(i == s.length() - 1) {
                sum += getNumber('-',s.charAt(i));
            } else {
                sum += getNumber(s.charAt(i + 1), s.charAt(i));
            }
        }

        return sum;
    }

    static int getNumber(char previous, char current) {
        return switch (current) {
            case 'I' -> {
                if (previous == 'X' || previous == 'V') {
                    yield -1;
                }
                yield 1;
            }
            case 'X' -> {
                if (previous == 'L' || previous == 'C') {
                    yield -10;
                }
                yield 10;
            }
            case 'C' -> {
                if (previous == 'D' || previous == 'M') {
                    yield -100;
                }
                yield 100;
            }
            case 'V' -> 5;
            case 'L' -> 50;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new RuntimeException();
        };
    }

    static void main() {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
