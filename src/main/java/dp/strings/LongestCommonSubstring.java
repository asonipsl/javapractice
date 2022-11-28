package dp.strings;

import java.util.Arrays;

public class LongestCommonSubstring {

    private static int t[][];
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abfce";
        t = new int[str1.length()+1][str2.length()+1];
        System.out.println(lcsDpTopDwn(str1,str2,str1.length(),str2.length()));
    }

    private static int lcsDpTopDwn(String str1, String str2, int m, int n) {
        for (int i = 0; i < str1.length()+1; i++) {
            for (int j = 0; j < str2.length()+1; j++) {
                if (i == 0 || j ==0 ) {
                    t[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                    max = Math.max(max,t[i][j]);  // < -- Substring can anywhere in between.
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return max;
    }
}
