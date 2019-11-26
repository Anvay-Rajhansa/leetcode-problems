package org.leetcode.problems;

/*In English, we have a concept called root, which can be followed by some other words to form another longer
word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the
sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
*/


import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    public static void main(String[] args) {
        System.out.println(replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));
    }

    private static String replaceWords(List<String> dict, String sentence) {
        StringBuilder stringBuilder = new StringBuilder();

        String[] words = sentence.split(" ");

        for (int i=0; i < words.length; i++) {
            boolean found = false;

            for (String root: dict) {
                if (words[i].startsWith(root)) {
                    found = true;
                    stringBuilder.append(root);
                    break;
                }
            }

            if(!found) {
                stringBuilder.append(words[i]);
            }

            if(i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
