public class KMP {
    public static int search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        if (m == 0) return 0;
        int[] lps = computePrefixArray(pattern);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                return i - j;

            }
            else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }
        return -1;

    }
    private static int[] computePrefixArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;
      lps[0] = 0;
        while (i < m) {
        if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];

            }else {
                lps[i] = 0;
                i++;

            }
        }
        }
        return lps;
    }
}
