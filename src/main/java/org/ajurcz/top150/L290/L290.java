package org.ajurcz.top150.L290;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.IntStream;

public class L290 {

    static boolean wordPattern(String pattern, String s) {
        var splitS = Arrays.asList(s.split("\\s+"));
        var patternToOccurrenceNumber = new HashMap<String, Integer>();

        if(splitS.size() != pattern.length()) return false;

        return IntStream.range(0, pattern.length()).allMatch(index -> {
            var patternCharacter = String.valueOf(pattern.charAt(index));
            var patternS = splitS.get(index);

            var lastValueIndex = patternToOccurrenceNumber.put("char" + patternCharacter, index);
            var lastValueS = patternToOccurrenceNumber.put("word" + patternS, index);

            return Objects.equals(lastValueIndex, lastValueS);
        });
    }

    static void main() {
        System.out.println(wordPattern("aba", "dog cat cat"));
    }
}
