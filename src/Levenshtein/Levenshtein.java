package Levenshtein;

public class Levenshtein {

    private static int getMin(int a, int b, int c) {
        int min = a;
        if (b < a) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    public static int LevenshteinDistance(String S, String T) {
        int m = S.length() + 1;
        int n = T.length() + 1;
        char[] s = new char[m];
        char[] t = new char[n];

        //++ xep ki tu cua chuoi s, t vao mang
        for (int i = 1; i < m; i++) {
            s[i] = S.charAt(i - 1);
        }
        for (int j = 1; j < n; j++) {
            t[j] = T.charAt(j - 1);
        }

        //++ khoi tao cac gia tri ban dau cho mang d[m,n]
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            d[0][j] = j;
        }

        //++ thuat toan Levenshtein distance
        int cost = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cost = 1;
                if (s[i] == t[j]) {
                    cost = 0;
                }
                d[i][j] = getMin(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);
            }
        }

        return d[s.length - 1][t.length - 1];
    }
}
