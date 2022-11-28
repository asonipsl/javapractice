package leetcode;

import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    private static Map<Character, Integer> romanToIntMap = new HashMap<>();
    private static Map<Character, Integer> romanIndexMap = new HashMap<>();
    static {
        romanToIntMap.put('I',1);
        romanToIntMap.put('V',5);
        romanToIntMap.put('X',10);
        romanToIntMap.put('L',50);
        romanToIntMap.put('C',100);
        romanToIntMap.put('D',500);
        romanToIntMap.put('M',1000);

        romanIndexMap.put('I',1);
        romanIndexMap.put('V',2);
        romanIndexMap.put('X',3);
        romanIndexMap.put('L',4);
        romanIndexMap.put('C',5);
        romanIndexMap.put('D',6);
        romanIndexMap.put('M',7);
    }
    public int romanToInt(String s) {
        int len = s.length();
        Character prevChar = null;
        int prevSum = 0;
        int total = 0;
        while (len > 0) {
            Character currentChar = s.charAt(len-1);
            int currentNum = romanToIntMap.get(currentChar);
            if (prevChar == null) {
                prevSum = currentNum;
                prevChar = currentChar;
            } else if (prevChar == currentChar) {
                prevSum += currentNum;
            } else if (romanIndexMap.get(currentChar) - romanIndexMap.get(prevChar) > 1) {
                total += prevSum;
                prevSum = currentNum;
                prevChar = currentChar;
            } else if (romanIndexMap.get(currentChar) - romanIndexMap.get(prevChar) < 0) {
                total = total + (prevSum-currentNum);
                prevSum = 0;
                prevChar = currentChar;
            }
            len--;
        }
        total+= prevSum;
        return total;
    }

    public static void main(String[] args) {
        RomanToInt s = new RomanToInt();
        System.out.println(s.romanToInt("MCMXCIV"));
    }
}
