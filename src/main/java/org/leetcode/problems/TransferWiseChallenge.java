package org.leetcode.problems;

/*

#Exercise 1 :

You have a rectangular apple orchard full of ripe apples. The orchard is divided into squares and is
represented by a 2 dimensional array. Each element in the array is an int, showing the number of apples
at the corresponding square in the orchard.
Our goal is to collect as many apples as we can by walking from the bottom left corner of the orchard to the top
right corner, taking all apples in each square along the way. From a given square you can only go either up,
or to the right.

For example consider that this is the orchard:
[[4, 0, 1],
[1, 0, 0],
[0, 4, 0]]

At most you can collect 6 apples, by going up (+1), up (+4), right (+0), right (+1).
Write a method that takes a 2 dimensional int array as the argument, and returns an int.
The returned int is the maximum number of apples that you can collect. Try to make sure that the method runs fast.

public int collectApples(int[][] orchard);

#Exercise 2 :

Let’s assume you also have 2 tokens. While you are walking in the orchard, you can use the tokens to
double the number of apples on the current square. You can only use one token on any given square.
Write another method which takes the tokens into account. The method signature should be like:

public int collectApplesWithTokens(int[][] orchard);

Please send a solution that you would release to production.
Also, please feel free to include/add any considerations and/or assumptions regarding your solution.

*/



/*
Question #1 - Romanizer
Problem
The table below contains some reference values for converting between integers (i.e., Arabic numerals) and Roman numerals:

Arabic	Roman		Arabic	Roman
1	I		40	XL
2	II		50	L
3	III		90	XC
4	IV		100	C
5	V		400	CD
6	VI		500	D
7	VII		900	CM
8	VIII		1000	M
9	IX
10	X
Given an integer, convert it to its Roman numeral equivalent.

Function Description
Complete the function romanizer in the editor below. The function must return an array of strings that represent
the integers as their Roman numeral equivalents.

romanizer has the following parameter(s): numbers[numbers[0],...numbers[n-1]]: an array of integers
*/


/*A URL is valid if it satisfies the following:

It starts with the protocol identifier http:// or https://.
The protocol identifier is followed by a host, which is a sequence of two or more period-separated labels. Each label
may consist of lowercase letters ([a-z]), dashes (-), and numbers ([0-9]) only. A hostname may (or may not)
start with the prefix www, ww2, or web.
The hostname may be followed by a path, which generally consists of a sequence of slash-separated segments. A valid
URL's domain name is the URL's hostname with the prefix removed. For example, consider the following table of sample
URLs and their associated domain names:
URL	Domain Name
http://hackerrank.com/	hackerrank.com
http://www.hackerrank.com/contest	hackerrank.com
http://www.xyz.com/news	xyz.com
http://web.xyz.com/about/mission	xyz.com
https://abc.xyz.com/jobs	abc.xyz.com
http://abcd.xyz.com/jobs2/	abcd.xyz.com
Note that the hostname prefixes (i.e., www., ww2., and web.) are trimmed from the domain name.
Given n lines of HTML markup fragments, we want to know all the unique potential domain names contained in the
fragments, in alphabetical order, as a single string of semicolon-separated values. For example, if the fragments
contain the valid URLs above, the answer is abc.xyz.com;abcd.xyz.com;hackerrank.com;xyz.com.

Function Description
Complete the function getPotentialDomains in the editor below. The function must return a string that contains all distinct valid domain names, separated by semi-colons and in lexicographical order.

getPotentialDomains has the following parameter(s): lines[lines[0],...lines[n-1]]: an array of strings*/


public class TransferWiseChallenge {
}
