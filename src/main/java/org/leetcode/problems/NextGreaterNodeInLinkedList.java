package org.leetcode.problems;

/*
We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2,
node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i,
node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a
linked list with a head node value of 2, second node value of 1, and third node value of 5.



Example 1:
Input: [2,1,5]
Output: [5,5,0]

Example 2:
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]

Example 3:
Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]


Note:

1 <= node.val <= 10^9 for each node in the linked list.
The given list has length in the range [0, 10000].
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,7,5,1,9,2,5,1]");

        int size  = 0;
        ListNode tempSize = head;
        while (tempSize.next != null) {
            size++;
            tempSize = tempSize.next;
        }

        int[] output = new int[size+1];

        int i = 0;
        while (head.next != null) {
            ListNode tempHead = head;
            boolean found = false;
            while (tempHead.next != null) {
                if(head.val < tempHead.next.val) {
                    output[i] = tempHead.next.val;
                    found = true;
                    break;
                }

                tempHead = tempHead.next;
            }

            if(!found) {
                output[i] = 0;
            }

            head = head.next;
            i++;
        }

        output[i] = 0;

        for (int val :
                output) {
            System.out.print(" " + val + " ");
        }
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}


