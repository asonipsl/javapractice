package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        int minIndex = -1;
        int inputCount = strs.length;
        for (int i = 0; i < inputCount; i++) {
            int len = strs[i].length();
            if (minLen > len) {
                minLen = len;
                minIndex = i;
            }
        }
        System.out.println("Min Length: " + minLen);
        if (minLen == 0) {
            return "";
        }
        int startWord = 0;
        String outStr = "";
        char ch;
        for (int j = 0; j < minLen; j++) {
            boolean matches = true;
            startWord = 0;
            ch = strs[minIndex].charAt(j);
            while (startWord < inputCount) {
                if (strs[startWord].charAt(j) != ch) {
                    matches = false;
                    break;
                }
                startWord++;
            }
            if(matches) {
                outStr = outStr.concat("" + ch);
            } else {
                break;
            }
        }
        return outStr;
    }

    public String leetCodeSolution(String[] strs) {
        String compare = strs[0];
        String result = "";
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length()<compare.length()){
                compare = compare.substring(0, strs[i].length());
            }
            for(int j = 0; j < strs[i].length(); j++){
                if(j >= compare.length()){
                    break;
                }else if(compare.charAt(j) != strs[i].charAt(j)){
                    compare = compare.substring(0, j);
                    break;
                }
            }
        }
        return compare;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flows","flight"};
        LongestCommonPrefix obj = new LongestCommonPrefix();
        long initTime = System.nanoTime();
        System.out.println(obj.longestCommonPrefix(strs));
        long finishTime = System.nanoTime();
        System.out.println("Total Time: " + (finishTime - initTime));

        initTime = System.nanoTime();
        System.out.println(obj.leetCodeSolution(strs));
        finishTime = System.nanoTime();
        System.out.println("Total Time: " + (finishTime - initTime));
    }
}
