package org.leetcode.problems;

/*Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]

horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example,

inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1*/

import com.eclipsesource.json.JsonArray;

public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] A = stringToInt2dArray("[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]");

        for(int i = 0; i < A.length; i++) {
            int[] image = A[i];
            int[] temp = new int[image.length];
            int tempSize = temp.length;

            for (int j = 0; j < image.length; j++) {
                if(image[j] == 0) {
                    temp[tempSize - 1] = 1;
                } else {
                    temp[tempSize - 1] = 0;
                }
                tempSize = tempSize - 1;
            }

            A[i] = temp;
        }

        for (int[] out: A) {
            for (int no: out) {
                System.out.print(no);
            }
            System.out.println("");
        }
    }


    public static int[] stringToIntegerArray(String input) {
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

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
}
