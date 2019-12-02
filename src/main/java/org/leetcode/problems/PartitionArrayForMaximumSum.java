package org.leetcode.problems;

/*Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.
After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.



Example 1:

Input: A = [1,15,7,9,2,5,10], K = 3 [15,10,9,7,5,2,1]
Output: 84
Explanation: A becomes [15,15,15,9,10,10,10]


Note:

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6*/

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }                                                     //[1,7,7,7,7,9,9,9,9,9,9]
                                                           //[9,9,7,6,5,4,3,3,1,1,1]



    private static int maxSumAfterPartitioning(int[] A, int K) {
        Arrays.sort(A);
        int total = 0;
        int length = A.length;

        for (int i = A.length - 1; length > 0; i--) {
            if(length < K) {
                total += A[i] * length;
            } else {
                total += A[i] * K;
            }
            length -= K;
        }

        return total;
    }
}
