package org.ajurcz.top150.L30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L30 {
    static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordToOccurency = new HashMap<>();
        List<Integer> resultStartIndices = new ArrayList<>();

        for (String word : words) {
            wordToOccurency.merge(word, 1, Integer::sum);
        }

        int wordLen = words[0].length();

        for (int offset = 0; offset < wordLen; offset++) {
            Map<String, Integer> currentWordToOccurency = new HashMap<>();
            int left = offset;
            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
                int endIndex = right + wordLen;
                String currentWord = s.substring(right, endIndex);
                if (shouldSkip(wordToOccurency, currentWord)) {
                    currentWordToOccurency.clear();
                    left = endIndex;

                    continue;
                }

                currentWordToOccurency.merge(currentWord, 1, Integer::sum);

                while (currentWordToOccurency.get(currentWord) > wordToOccurency.get(currentWord)) {
                    String leftmostSubstring = s.substring(left, left + wordLen);
                    if (currentWordToOccurency.merge(leftmostSubstring, -1, Integer::sum) == 0)
                        currentWordToOccurency.remove(leftmostSubstring);
                    left += wordLen;
                }

                if (endIndex - left == words.length * wordLen) resultStartIndices.add(left);
            }

        }

        return resultStartIndices;
    }

    static boolean shouldSkip(Map<String, Integer> wordToOccurency, String nextWord) {
        return !wordToOccurency.containsKey(nextWord);
    }

    static void main() {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));

        // We should skip comparing substring if: substring not equals one of words, or we already
        // have more occurencies than we should
    }
}
