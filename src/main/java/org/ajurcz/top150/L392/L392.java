package org.ajurcz.top150.L392;

public class L392 {
    static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    static void main() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
