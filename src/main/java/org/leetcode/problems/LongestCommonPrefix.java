package org.leetcode.problems;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }

        String output = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String matchingPrefix = "";
            int checkLength = Math.min(strs[i].length(), output.length());
            for (int j = 0; j < checkLength; j++) {
                if(output.charAt(j) == strs[i].charAt(j)) {
                    matchingPrefix += output.charAt(j);
                } else {
                    break;
                }
            }

            if(matchingPrefix.isEmpty()) {
                output = "";
                break;
            } else {
                output = matchingPrefix;
            }
        }

        return output;
    }
}
