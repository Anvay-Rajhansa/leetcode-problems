package org.leetcode.problems;

/*

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the
pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern.

You may return the answer in any order.


Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.


Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public static void main(String[] args) {
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        List<String> output = new ArrayList<>();

        Map<String, String> stringMap = new HashMap<>();

        for (String s: words) {
            boolean valid = true;
            stringMap.clear();
            for (int i = 0; i < s.length(); i++) {
                String wordChar = String.valueOf(s.charAt(i));
                String patternChar = String.valueOf(pattern.charAt(i));

                if(stringMap.containsKey(patternChar)) {
                    if(!stringMap.get(patternChar).equals(wordChar)) {
                        valid = false;
                        break;
                    }
                } else if(stringMap.containsValue(wordChar)) {
                    valid = false;
                    break;
                } else {
                    stringMap.put(patternChar, wordChar);
                }
            }

            if(valid) {
                output.add(s);
            }
        }

        for (String s: output) {
            System.out.println(s);
        }
    }
}
