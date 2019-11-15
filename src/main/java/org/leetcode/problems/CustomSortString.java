package org.leetcode.problems;

/*
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order
that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"

Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.
*/

public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(customSortString("cbax", "dcbccxcabbabybbcad"));
    }

    private static String customSortString(String S, String T) {

        StringBuilder stringBuilder = new StringBuilder();

        /*for (char ch: S.toCharArray()) {
            while (T.indexOf(ch) != -1) {
                stringBuilder.append(ch);
                T =  T.substring(0, T.indexOf(ch)) + T.substring(T.indexOf(ch) + 1);
            }
        }*/

        //more optimized

        int[] intt = new int[26];

        for (char ch: T.toCharArray()) {
            intt[ch - 'a']++;
        }

        for (char ch: S.toCharArray()) {

            for (int i = 0; i < intt[ch - 'a']; i++) {
                stringBuilder.append(ch);
            }

            intt[ch - 'a'] = 0;
        }

        for (int i = 0; i < intt.length; i++) {
            if(intt[i] > 0) {
                for (int j = 0; j < intt[i]; j++) {
                    stringBuilder.append((char)(i + 'a'));
                }
            }
        }

        return stringBuilder.toString();
    }
}
