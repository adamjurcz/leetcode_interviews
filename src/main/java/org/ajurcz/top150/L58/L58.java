package org.ajurcz.top150.L58;

public class L58 {

    static int lengthOfLastWord(String s) {
        var words = s.split("\\s+");

        System.out.printf("There are %d words", words.length);

        return words[words.length - 1].length();
    }

    static void main() {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
