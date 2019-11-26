package org.leetcode.problems;

/*

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/

class TrieNode {
    TrieNode[] child;
    boolean isPresent;

    public TrieNode() {
        this.child = new TrieNode[26];
        this.isPresent = false;
    }
}

class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            if(temp.child[word.charAt(i) - 'a'] == null) {
                temp.child[word.charAt(i) - 'a'] = new TrieNode();
            }

            temp = temp.child[word.charAt(i) - 'a'];
        }

        temp.isPresent = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            if(temp.child[word.charAt(i) - 'a'] == null) {
                return false;
            }

            temp = temp.child[word.charAt(i) - 'a'];
        }

        return temp.isPresent;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for (int i = 0; i < prefix.length(); i++) {
            if(temp.child[prefix.charAt(i) - 'a'] == null) {
                return false;
            }

            temp = temp.child[prefix.charAt(i) - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/*["Trie","insert","search","search","search","startsWith","startsWith","startsWith"]
[[],["hello"],["hell"],["helloa"],["hello"],["hell"],["helloa"],["hello"]]*/

/*output - [null,null,false,true,true,true,false,true]*/

/*expected - [null,null,false,false,true,true,false,true]*/

public class ImplementTriPrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

        /*trie.insert("hello");
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("helloa"));
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("hell"));
        System.out.println(trie.startsWith("helloa"));
        System.out.println(trie.startsWith("hello"));*/
    }
}
