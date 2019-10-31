package org.leetcode.problems;

/*
Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into
the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist
in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
You can return any of them.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5

This tree is also valid:

         5
       /   \
      2     7
     / \
    1   3
         \
          4
*/


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}



public class InsertIntoABinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = stringToTreeNode("[4,2,7,1,3]");
        int val = 5;

        TreeNode traversal = root;
        while(traversal != null) {
            if(val < traversal.val) {
                if(traversal.left == null) {
                    TreeNode treeNode = new TreeNode(val);
                    traversal.left = treeNode;
                    break;
                } else {
                    traversal = traversal.left;
                }
            } else {
                if(traversal.right == null) {
                    TreeNode treeNode = new TreeNode(val);
                    traversal.right = treeNode;
                    break;
                } else {
                    traversal = traversal.right;
                }
            }
        }

        System.out.println(treeNodeToString(root));
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
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
