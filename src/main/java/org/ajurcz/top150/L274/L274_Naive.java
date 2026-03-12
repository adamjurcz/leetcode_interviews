package org.ajurcz.top150.L274;

public class L274_Naive {

    /// Jest o wiele lepsza wersja
    static int hIndex(int[] citations) {
        int h = 0;
        for (int i = 1; i <= citations.length; i++) {
            int ind = 0;
            int citationNumber = 0;
            while (ind <= citations.length - 1) {
                if (citations[ind] >= i) {
                    citationNumber++;
                }
                if (citationNumber >= i) {
                    break;
                }
                ind++;
            }
            if (citationNumber >= i) {
                h++;
            }
        }
        return h;
    }


    static void main() {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
