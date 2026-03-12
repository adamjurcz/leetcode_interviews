package org.ajurcz.top150.L383;

import java.util.HashMap;
import java.util.stream.IntStream;

public class L383 {

    static boolean canConstruct(String ransomNote, String magazine) {
        var lettersCount = new HashMap<String, Integer>();

        magazine.chars().forEach(character ->
                lettersCount.merge(String.valueOf((char) character), 1, Integer::sum));

        return IntStream.range(0, ransomNote.length()).allMatch(index ->
                lettersCount.merge(String.valueOf(ransomNote.charAt(index)), -1, Integer::sum) >= 0);
    }

    static void main() {
        System.out.println(canConstruct("aab", "aaab"));
    }
}
