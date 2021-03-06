package org.leetcode.problems;


/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.



Example 1:
Input: [1,7,0,7,-8,null,null]
Output: 2

Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.


Note:

The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5

*/


import java.util.ArrayList;
import java.util.List;

public class MaximumLevelSumOfABinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("[1,7,0,7,-8]");
        System.out.println(maxLevelSum(treeNode));
    }

    public static int maxLevelSum(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);

        int max = Integer.MIN_VALUE;
        int level = 1;

        int i = 1;
        while (!treeNodes.isEmpty()) {
            int sum = 0;

            List<TreeNode> newTreeNodes = new ArrayList<>();

            for (TreeNode node : treeNodes) {
                if(node != null) {
                    sum += node.val;
                    newTreeNodes.add(node.left);
                    newTreeNodes.add(node.right);
                }
            }

            if(sum > max) {
                max = sum;
                level = i;
            }

            i++;
            treeNodes = newTreeNodes;
        }

        return level;
    }
}
