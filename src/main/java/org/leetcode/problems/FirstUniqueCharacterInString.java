package org.leetcode.problems;


/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.

*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String s = "leetcode";

        Map<String, Integer> uniqueMap = new HashMap<>();
        List<String> repeatList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(repeatList.contains(String.valueOf(c))) {
                continue;
            }

            if(uniqueMap.containsKey(String.valueOf(c))) {
                repeatList.add(String.valueOf(c));
                uniqueMap.remove(String.valueOf(c));
                continue;
            }

            uniqueMap.put(String.valueOf(c), i);
        }

        if(uniqueMap.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(Collections.min(uniqueMap.values()));
        }
    }

}
