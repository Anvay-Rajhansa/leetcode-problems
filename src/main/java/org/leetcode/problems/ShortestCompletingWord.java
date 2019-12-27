package org.leetcode.problems;


/*
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate.
Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP",
the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"

Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".

Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"

Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.


Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].
*/


import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestCompletingWord {

    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        PriorityQueue<String> outputQueue = new PriorityQueue<>(words.length,
                Comparator.comparing(String::length));

        licensePlate = licensePlate.replaceAll("[^A-Za-z]","").trim().toLowerCase();

        for(String word: words) {
            int count = 0;
            String originalWord = word;
            for (char ch: licensePlate.toCharArray()) {

                if(word.contains(String.valueOf(ch))) {
                    String first = word.substring(0, word.indexOf(ch));
                    String second = word.substring(word.indexOf(ch) + 1);
                    word =  first + second;
                    count ++;
                }
            }

            if(count == licensePlate.length()) {
                outputQueue.add(originalWord);
            }
        }

        return outputQueue.peek();
    }
}
