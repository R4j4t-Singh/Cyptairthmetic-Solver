package com.example.cryptairthmetic;

import java.util.HashMap;

public class Cryptarithmetic_multi {
    public String sc = "";
    int count = 0;
    int ans;

    public String solver(String s1, String s2, String s3) {

        Cryptarithmetic_multi C = new Cryptarithmetic_multi();
        HashMap<Character, Integer> maps = new HashMap<>();

        String string = s1 + s2 + s3;

        boolean[] numbers = new boolean[10];

        String characters = "";

//      taking unique alphabets from the input strings
//      and putting it to Hashmap each having values = -1

        for (int i = 0; i < string.length(); i++) {
            char s = string.charAt(i);
            if (characters.indexOf(s) == -1) {
                maps.put(s, -1);
                characters += s;

            }
        }

//  Main method where we use backtracking algorithm
        String a = C.SolveCryptarithmetic(characters, 0, maps, numbers, s1, s2, s3);
        ans = C.count;
        return a;
    }

    //  using backtracking algorithm
    String SolveCryptarithmetic(String characters, int k, HashMap<Character, Integer> maps, boolean[] numbers, String a, String b, String c) {

//     	base condition
        if (k == characters.length()) {
            int num1 = getnum(a, maps);
            int num2 = getnum(b, maps);
            int num3 = getnum(c, maps);
            if (num1 * num2 == num3) {
                count++;
                String sol = "";
                for (int i = 0; i < characters.length(); i++) {
                    sol += (characters.charAt(i) + "-" + maps.get(characters.charAt(i)) + "   ");
                }
                sc = sc + sol + "\n";
            }

            return sc;
        }

        char ch = characters.charAt(k);
        for (int i = 0; i < 10; i++) {
            if (numbers[i] == false) {
                maps.replace(ch, i);
                numbers[i] = true;
                SolveCryptarithmetic(characters, k + 1, maps, numbers, a, b, c);
                numbers[i] = false;
                maps.replace(ch, -1);
            }
        }

        return sc;
    }

    //   this method provide num a unique number of a particular string
//   for the operation to be performed
    int getnum(String str, HashMap<Character, Integer> maps) {
        String num = "";

        for (int i = 0; i < str.length(); i++) {
            num += maps.get(str.charAt(i));
        }

        return Integer.parseInt(num);

    }
}
