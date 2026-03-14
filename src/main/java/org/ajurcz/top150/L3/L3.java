package org.ajurcz.top150.L3;

import java.util.HashSet;
import java.util.Set;

public class L3 {
    static int lengthOfLongestSubstring(String s) {
        Set<Character> usedCharacters = new HashSet<>();
        int left = 0;
        int longestSubstringLength = Integer.MIN_VALUE;

        for (int right = 0; right < s.length(); right++) {
            while (usedCharacters.contains(s.charAt(right))) {
                char leftChar = s.charAt(left);
                usedCharacters.remove(leftChar);
                left++;
            }

            usedCharacters.add(s.charAt(right));
            longestSubstringLength = Math.max(longestSubstringLength, right - left + 1);
        }

        return longestSubstringLength == Integer.MIN_VALUE ? 0 : longestSubstringLength;
    }

    static void main() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // abc -> abca -> bca -> bcab -> cab -> cabc -> ...
    }
}
