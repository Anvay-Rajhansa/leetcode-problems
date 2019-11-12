package org.leetcode.problems;


/*

Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot
be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once.
Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.



Example 1:

Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"],
score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]

Output: 23

Explanation:
Score  a=1, c=9, d=5, g=3, o=2
Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
Words "dad" and "dog" only get a score of 21.

Example 2:

Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"],
score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]

Output: 27

Explanation:
Score  a=4, b=4, c=4, x=5, z=10
Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
Word "xxxz" only get a score of 25.

Example 3:

Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"],
score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]

Output: 0

Explanation:
Letter "e" can only be used once.


Constraints:
1 <= words.length <= 14
1 <= words[i].length <= 15
1 <= letters.length <= 100
letters[i].length == 1
score.length == 26
0 <= score[i] <= 10
words[i], letters[i] contains only lower case English letters.
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumScoreWordsFormedByLetters {

    public static void main(String[] args) {
//        String[] words = new String[]{"dog","cat","dad","good"};
//        char[] letters = new char[]{'a','a','c','d','d','d','g','o','o'};
//        int[] score = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

//        String[] words = new String[]{"xxxz","ax","bx","cx"};
//        char[] letters = new char[]{'z','a','b','c','x','x','x'};
//        int[] score = new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};

//        String[] words = new String[]{"leetcode"};
//        char[] letters = new char[]{'l','e','t','c','o','d','e'};
//        int[] score = new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};

        //expected : 62
//        String[] words = new String[]{"ac","abd","db","ba","dddd","bca"};
//        char[] letters = new char[]{'a','a','a','b','b','b','c','c','d','d','d','d'};
//        int[] score = new int[]{6,4,4,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        //expected: 49
//        String[] words = new String[]{"da","ac","aba","abcc","cadc"};
//        char[] letters = new char[]{'a','a','a','a','b','c','c','c','d','d','d'};
//        int[] score = new int[]{3,7,9,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


        //expected: 27
        String[] words = new String[]{"bdabd","bec","cbeb","bceb","dde"};
        char[] letters = new char[]{'a','a','a','b','b','b','b','c','c','c','d','d','e','e'};
        int[] score = new int[]{10,2,6,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


        System.out.println(maxScoreWords(words, letters, score));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] finalScores = new int[words.length];

        List<String> letterList = new ArrayList<>();

        for (char ch: letters) {
            letterList.add(String.valueOf(ch));
        }


        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<String> letterCopy = new ArrayList<>(letterList);
            int scoree = 0;

            boolean flag = true;

            if(letterCopy.isEmpty()) {
                break;
            }

            for (char ch : word.toCharArray()) {

                if(letterCopy.isEmpty() || !letterCopy.contains(String.valueOf(ch))) {
                    flag = false;
                    break;
                }

                letterCopy.remove(String.valueOf(ch));
                scoree += score[ch - 'a'];
            }

            if(!flag) {
                continue;
            }

            int j = i + 1;

            if(i != words.length - 1) {

                while (j != i) {

                    //}

                    ///for (int j = i + 1; j < words.length; j++) {


                    //    if(i == j) {
                    //        continue;
                    //    }

                    boolean isContain = true;
                    List<String> lettercopy1 = new ArrayList<>(letterCopy);

                    for (char ch : words[j].toCharArray()) {

                        if (lettercopy1.isEmpty() || !lettercopy1.contains(String.valueOf(ch))) {
                            isContain = false;
                            break;
                        }

                        lettercopy1.remove(String.valueOf(ch));
                    }

                    if (isContain) {
                        for (char ch : words[j].toCharArray()) {
                            letterCopy.remove(String.valueOf(ch));
                            scoree += score[ch - 'a'];
                        }
                    }

                    if (j == words.length - 1) {
                        j = 0;
                    } else {
                        j++;
                    }
                }
            }

            finalScores[i] = scoree;
        }

        return Arrays.stream(finalScores).max().getAsInt();

    }
}
