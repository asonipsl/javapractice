package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int cf = 1;
        int n = digits.length;
        int[] ret;
        ret = new int[digits.length + 1];
        while (n > 0 && cf == 1) {
            int num = digits[n-1] + cf;
            ret[n-1] = num % 10;
            digits[n-1] = ret[n-1];
            if (num % 10 == 0) {
                cf = 1;
                n--;
            } else {
                cf = 0;
                break;
            }
        }
        if (cf == 1 && n == 0) {
            ret[0] = 1;
            return ret;
        } else {
            return digits;
        }
    }
}
