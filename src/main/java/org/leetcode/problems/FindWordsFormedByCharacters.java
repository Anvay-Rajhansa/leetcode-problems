package org.leetcode.problems;

/*

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6

Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10

Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.


Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.

*/

public class FindWordsFormedByCharacters {

    public static void main(String[] args) {

        String[] words = new String[]{"hello","world","leetcode"};
        String chars = "welldonehoneyr";

        int totalLength = 0;

        int[] charss = new int[26];
        for(int i = 0; i < chars.length(); i++) {
            int index = chars.charAt(i) - 'a';
            charss[index] = charss[index] == 0 ? 1 : (charss[index] + 1);
        }

        for (String word : words) {

            int[] copyChar = charss.clone();
            boolean valid = true;

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                int index = ch - 'a';

                int value = copyChar[index];

                if (value == 0) {
                    valid = false;
                    break;
                } else {
                    copyChar[index] = copyChar[index] - 1;
                }
            }

            if (valid) {
                totalLength += word.length();
            }

        }

        System.out.println(totalLength);
    }
}
