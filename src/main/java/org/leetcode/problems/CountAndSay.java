package org.leetcode.problems;

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/


import java.util.Stack;

public class CountAndSay {

	public static void main(String[] args) {
		int n = 6;

		StringBuilder stringBuilder = new StringBuilder("1");

		for (int i = 1; i < n; i++) {
			String s = stringBuilder.toString();
			stringBuilder = new StringBuilder();
			char[] c =  s.toCharArray();

			for(int j = 0; j < c.length; j++) {
				char temp = c[j];
				int count = 1;

				while ((j + 1) < c.length && temp == c[j + 1]) {
					count ++;
					j++;
				}

				stringBuilder.append(count).append(temp);
			}
		}

		System.out.println(stringBuilder.toString());
	}
}
