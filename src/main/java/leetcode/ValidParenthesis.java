package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> closingComplimentMap = new HashMap<>();
        closingComplimentMap.put(')','(');
        closingComplimentMap.put(']','[');
        closingComplimentMap.put('}','{');
        int index = -1;
        String tmpStr = "";
        for (Character ch: s.toCharArray()) {
            if (closingComplimentMap.containsKey(ch)) {
                if (index != -1 && tmpStr.charAt(index) == closingComplimentMap.get(ch)) {
                    index--;
                    if (index != -1) {
                        tmpStr = tmpStr.substring(0, tmpStr.length()-1);
                    } else {
                        tmpStr = "";
                    }
                } else {
                    return false;
                }
            } else {
                tmpStr = tmpStr.concat("" + ch);
                index++;
            }
        }
        if (index == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String input = "){";
        System.out.println("Output: " + new ValidParenthesis().isValid(input));
    }
}
