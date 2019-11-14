package org.leetcode.problems;


/*Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1,
and return them in any order.

The graph is given as follows:  the nodes
are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.


Example:
Input: [[1,2], [3], [3], []]

Output: [[0,1,3],[0,2,3]]

Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Note:
The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.

*/

import com.eclipsesource.json.JsonArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        //int[][] graph = stringToInt2dArray("[[1,2], [3], [], []]");
        int[][] graph = stringToInt2dArray("[[4,3,1],[3,2,4],[3],[4],[]]");
        List<List<Integer>> output  = allPathsSourceTarget(graph);

        for (int i = 0; i < output.size(); i++) {
            System.out.print(i + " : ");
            for (Integer in: output.get(i)){
                System.out.print(" " + in);
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> output = new ArrayList<>();

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(map.containsKey(i)) {
                    map.put(i, map.get(i) + "," + graph[i][j]);
                } else {
                    map.put(i, String.valueOf(graph[i][j]));
                }
            }
        }


        String[] nodes = map.get(0).split(",");

        if(nodes.length == 0) {
            return output;
        }

        for (String node : nodes) {

            List<Integer> path = new ArrayList<>();
            path.add(0);
            path.add(Integer.valueOf(node));
            boolean flag = true;

            while (flag) {
                String val = map.get(Integer.valueOf(node));

                if(val == null) {
                    flag = false;
                    break;
                }

                path.add(Integer.valueOf(val));

                if(Integer.valueOf(val) == graph.length - 1) {
                    flag = false;
                    output.add(path);
                }
            }
        }

        return output;
    }

    /*public static List<Integer> getList(Map<Integer, String> map, Integer node, int length) {
        String val = map.get(node);

        if(val == null) {
            return new ArrayList<>();
        }



        if()
    }*/

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
