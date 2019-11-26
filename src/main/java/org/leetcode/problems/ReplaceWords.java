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


        TriNode root = new TriNode();

        for (String word: dict) {
            addWordInTri(root, word);
        }

        for (String word: sentence.split(" ")) {
            stringBuilder.append(getWordFromTri(root, word)).append(" ");
        }

        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }


    private static void addWordInTri(TriNode root, String word) {

        TriNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(temp.getChildNode()[c-'a'] == null) {
                temp.getChildNode()[c-'a'] = new TriNode();
            }

            temp = temp.getChildNode()[c-'a'];
        }

        temp.setWorld(word);
    }

    private static String getWordFromTri(TriNode root, String word) {

        TriNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(temp.getChildNode()[c - 'a'] == null) {
                return word;
            }

            temp = temp.getChildNode()[c-'a'];

            if(temp.getWorld() != null) return temp.getWorld();
        }

        return word;
    }
}

class TriNode {
    private final TriNode[] childNode;
    private String world;

    public TriNode() {
        this.childNode = new TriNode[26];
    }

    public TriNode[] getChildNode() {
        return childNode;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public String getWorld() {
        return world;
    }
}
