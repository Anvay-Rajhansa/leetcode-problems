package org.leetcode.problems;

/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.

The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.

The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
Note:
The size of the given array will be in the range [1,1000].
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};

        System.out.println(treeNodeToString(calculateMaxTree(nums, 0, nums.length)));
    }

    public static TreeNode calculateMaxTree(int[] value, int start, int end) {
        if(start == end) {
            return null;
        }

        int max = value[0];
        int i = 1;
        for(; i < value.length;i++) {
            if(value[i] > max) {
                max = value[i];
            }
        }

        int index = Arrays.stream(value).boxed().collect(Collectors.toList()).indexOf(max);
        TreeNode treeNode = new TreeNode(max);

        int[] rightArray = Arrays.copyOfRange(value, index, value.length);
        int[] leftArray = Arrays.copyOfRange(value, 0, index);

        treeNode.right = calculateMaxTree(rightArray, 0, rightArray.length);

        treeNode.left = calculateMaxTree(leftArray, 0, leftArray.length);

        return treeNode;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
}
