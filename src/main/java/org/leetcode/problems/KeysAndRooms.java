package org.leetcode.problems;


/*
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each
room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.

Example 2:
Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.

[[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]
     -    -   -      -   -   -    -   -  -
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;



public class KeysAndRooms {

    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(Arrays.asList(Arrays.asList(4), Arrays.asList(3), Arrays.asList(),
                Arrays.asList(2,5,7), Arrays.asList(1),Arrays.asList(),Arrays.asList(8,9), Arrays.asList(),
                Arrays.asList(), Arrays.asList(6))));
    }

    private static Map<Integer, List<Integer>> keys = new HashMap<>();

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        for (int room = 0; room < rooms.size(); room++) {
            keys.put(room, rooms.get(room));
        }

        dfs(rooms.get(0), visited);
        return visited.size() == rooms.size();
    }

    private static void dfs(List<Integer> rooms, Set<Integer> visited) {
        for (int room : rooms) {
            if (!visited.contains(room)) {
                visited.add(room);
                dfs(keys.get(room), visited);
            }
        }
    }
}
