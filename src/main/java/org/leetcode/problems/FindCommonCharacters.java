package org.leetcode.problems;


/*Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all
strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings
but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

Example 1:
Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: ["cool","lock","cook"]
Output: ["c","o"]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {

    public static void main(String[] args) {
        String[] A = new String[]{"cool","lock","cook"};

        Map<String, Integer> charCountMap = new HashMap<>();
        List<String> output = new ArrayList<>();

        String firstWord = A[0];
        char[] firstWordArray = firstWord.toCharArray();

        for (int i = 0; i < firstWordArray.length; i++) {
            boolean flag = true;
            for (int j = 1; j < A.length; j++) {
                String word = A[j];

                if(word.contains(String.valueOf(firstWordArray[i]))) {
                    int index = word.indexOf(String.valueOf(firstWordArray[i]));
                    A[j] = word.substring(0, index) + word.substring(index + 1);
                } else {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                charCountMap.computeIfPresent(String.valueOf(firstWordArray[i]), (k, v) -> v = v + 1);
                charCountMap.putIfAbsent(String.valueOf(firstWordArray[i]), 1);
            }

        }

        charCountMap.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                output.add(k);
            }
        });


        for (String out: output) {
            System.out.println(out);
        }
    }
}
