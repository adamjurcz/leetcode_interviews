package org.ajurcz.top150.L151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L151 {

    static String reverseWords(String s) {
        List<String> words = Arrays.stream(s.trim().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));

        Collections.reverse(words);
        return String.join(" ", words);
    }

    static void main() {
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("  hello world  "));
    }
}
