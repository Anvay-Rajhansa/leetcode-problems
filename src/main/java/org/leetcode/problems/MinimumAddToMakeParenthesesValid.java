package org.leetcode.problems;

/*Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')',
and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.



Example 1:
Input: "())"
Output: 1

Example 2:
Input: "((("
Output: 3

Example 3:
Input: "()"
Output: 0

*/

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }

    private static int minAddToMakeValid(String S) {
        if(S == null || S.isEmpty()) {
            return 0;
        }

        //Stack solution.
        /*int count = 0;
        Stack<String> stack = new Stack<>();

        for (char ch: S.toCharArray()) {
            if(ch == '(') {
                stack.push("(");
            } else {
                if(stack.empty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }

        return count + stack.size();*/


        int open = 0;
        int close = 0;

        for (char ch: S.toCharArray()) {
            if(ch == '(') {
                open++;
            } else {
                if(open == 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }

        return open + close;
    }
}
