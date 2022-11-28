package dp.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private static int t[][];
    private static int rec,recmem = 0;
    public static void main(String[] args) {
        String str1 = "abcdefabc";
        String str2 = "abdcdfahg";

        System.out.println("\n LCS is = " + lcs(str1,str2,str1.length(),str2.length()));

        t = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < str1.length()+1; i++) {
            Arrays.fill(t[i], -1);
        }
        System.out.println("\n LCS Memoized is = " + lcsMemoization(str1,str2,str1.length(),str2.length()));
        System.out.println("Rec: " + rec + ", Recmem: " + recmem);
        System.out.println("\n LCS Top Down is = " + lcsDpTopDwn(str1,str2,str1.length(),str2.length()));
    }

    private static int lcsDpTopDwn(String str1, String str2, int m, int n) {
        for (int i = 0; i < str1.length()+1; i++) {
            for (int j = 0; j < str2.length()+1; j++) {
                if (i == 0 || j ==0 ) {
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }

    private static int lcs(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        rec++;
        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return 1 + lcs(str1,str2,m-1,n-1);
        } else {
            return Math.max(lcs(str1,str2,m-1,n),lcs(str1,str2,m,n-1));
        }
    }

    private static int lcsMemoization(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (t[m][n] != -1) {
            return t[m][n];
        }
        recmem++;
        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return t[m][n] = 1 + lcsMemoization(str1,str2,m-1,n-1);
        } else {
            return t[m][n] = Math.max(lcsMemoization(str1,str2,m-1,n),lcsMemoization(str1,str2,m,n-1));
        }
    }

}
