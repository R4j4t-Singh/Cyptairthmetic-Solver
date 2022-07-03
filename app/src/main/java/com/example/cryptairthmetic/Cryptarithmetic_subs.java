package com.example.cryptairthmetic;

import java.util.HashMap;

public class Cryptarithmetic_subs {
    //   this method provide num a unique number of a particular string
    //   for the operation to be performed
    int count = 0;
    public String sc = "";
    int ans;

    public static int getNumber(String s, HashMap<Character, Integer> charIntMap) {
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            num += charIntMap.get(s.charAt(i));
        }
        return Integer.parseInt(num);
    }

    //  using backtracking algorithm
    public  String answer(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
                              String s1, String s2, String s3) {

        //    	 base condition
        if (idx == unique.length()) {
            int num1 = getNumber(s1, charIntMap);
            int num2 = getNumber(s2, charIntMap);
            int num3 = getNumber(s3, charIntMap);
            String c = "";

            if (num1 - num2 == num3) {
                count++;
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('A' + i);
                    String sol = "";
                    if (charIntMap.containsKey(ch)) {
                        sol += (ch + "-" + charIntMap.get(ch) + " ");
                    }
                    c += sol;
                }
                sc += c + "\n";
            }
            return sc;
        }

        char ch = unique.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (!usedNumbers[num]) {
                charIntMap.put(ch, num);
                usedNumbers[num] = true;
                answer(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                usedNumbers[num] = false;
            }
        }
        return sc;
    }

    public String solver(String s1, String s2, String s3) {

//      taking unique alphabets from the input strings
//      and putting it to Hashmap each having values = -1
        Cryptarithmetic_subs C = new Cryptarithmetic_subs();
        HashMap<Character, Integer> charIntmap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntmap.containsKey(s1.charAt(i))) {
                charIntmap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntmap.containsKey(s2.charAt(i))) {
                charIntmap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntmap.containsKey(s3.charAt(i))) {
                charIntmap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

//      Main method where we use backtracking algorithm

        boolean[] usedNumbers = new boolean[10];
        String a = C.answer(unique, 0, charIntmap, usedNumbers, s1, s2, s3);
        ans = C.count;
        return a;
    }
}
